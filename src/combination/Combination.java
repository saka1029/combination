package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

public class Combination {

	private static <T> Set<T> duplicated(List<T> elements) {
		Map<T, Integer> count = new HashMap<>();
		for (T e : elements) {
			Integer i = count.get(e);
			if (i == null) i = 0;
			count.put(e, i + 1);
		}
		Set<T> result = new HashSet<>();
		for (Entry<T, Integer> e : count.entrySet())
			if (e.getValue() > 1)
				result.add(e.getKey());
		return result;
	}

	private static <T> void found(int[] combination, List<T> elements,
			Set<T> duplicated, Set<List<T>> pool, Consumer<List<T>> callback) {
		List<T> result = new ArrayList<>();
		for (int i : combination)
			result.add(elements.get(i));
		for (T e : result)
			if (duplicated.contains(e)) {
				pool.add(result);
				return;
			}
		callback.accept(result);
	}

	private static <T> void combination(List<T> elements, int k,
			Consumer<List<T>> callback, Set<T> duplicated) {
		Set<List<T>> pool = new HashSet<>();
		int n = elements.size();
		if(k > n)
			throw new IllegalArgumentException("k must <= elements size");
		int combination[] = new int[k];
		int r = 0;		
		int index = 0;
		while(r >= 0) {
			if(index <= n + r - k) {
                combination[r] = index;
				if(r == k - 1) {
					index++;
					found(combination, elements, duplicated, pool, callback);
				} else
					index = combination[r++] + 1;
			} else if(--r >= 0)
                index = combination[r] + 1;
		}
//		System.out.println("pool=" + pool);
		for (List<T> e : pool)
			callback.accept(e);
	}

	public static <T> void allCombinations(List<T> elements, Consumer<List<T>> callback) {
		Set<T> duplicated = duplicated(elements);
//		System.out.println("duplicated=" + duplicated);
		for (int i = 1, size = elements.size(); i <= size; ++i)
            combination(elements, i, callback, duplicated);
	}

	public static void main(String[] args) {
		allCombinations(Arrays.asList(1, 1, 2, 3),
			list -> {
                System.out.println(list);
            }
		);
	}
	
}