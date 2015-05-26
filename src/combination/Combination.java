package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Combination {

	public static <T> void found(int[] combination, List<T> elements, List<T> result, Consumer<List<T>> callback) {
		int length = combination.length;
		for (int i = 0; i < length; ++i)
			result.set(i, elements.get(combination[i]));
		callback.accept(result);
	}

	public static <T> void combination(List<T> elements, int k, Consumer<List<T>> callback) {
		List<T> result = new ArrayList<>(k);
		for (int i = 0; i < k; ++i)
			result.add(null);
		int n = elements.size();
		if(k > n)
			throw new IllegalArgumentException("Invalid input, k > n");
		int combination[] = new int[k];
		int r = 0;		
		int index = 0;
		while(r >= 0) {
			if(index <= n + r - k) {
                combination[r] = index;
				if(r == k - 1) {
					index++;
					found(combination, elements, result, callback);
				} else
					index = combination[r++] + 1;
			} else if(--r >= 0)
                index = combination[r] + 1;
		}
	}

	static <T> void fold(List<T> list, List<T> folded, List<Integer> count) {
		folded.clear();
		count.clear();
		for (T e : list) {
			int i = folded.indexOf(e);
			if (i == -1) {
				folded.add(e);
				count.add(1);
			} else
				count.set(i, count.get(i) + 1);
		}
		
	}

	public static void testCombination() {
		List<Integer> elements = Arrays.asList(1, 1, 2, 3);
		List<Integer> folded = new ArrayList<>();
		List<Integer> count = new ArrayList<>();
		fold(elements, folded, count);
		System.out.printf("elements = %s folded = %s count=%s%n", elements, folded, count);
		for (int i = 1, max  = elements.size(); i <= max; ++i)
            combination(elements, i, x -> { System.out.println(x); });
	}
		
	public static void main(String[] args){
		testCombination();
	}
	
}