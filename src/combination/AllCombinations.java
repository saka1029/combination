package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class AllCombinations<T> {

	final List<T> uniqs = new ArrayList<>();
	final List<Integer> sizes = new ArrayList<>();
	final int max;
	final int[] counts;
	final Consumer<List<T>> callback;

	private AllCombinations(List<T> elements, Consumer<List<T>> callback) {
		Map<T, Integer> map = new HashMap<>();
		for (T e : elements) {
            Integer i = map.get(e);
            if (i == null) i = 0;
            map.put(e, i + 1);
		}
		for (Entry<T, Integer> e : map.entrySet()) {
			this.uniqs.add(e.getKey());
			this.sizes.add(e.getValue());
		}
		this.max = uniqs.size();
		this.counts = new int[max];
		this.callback = callback;
	}

	void found(int[] counts, int total) {
//		System.out.println("answer=" + Arrays.toString(counts));
		if (total <= 0) return;
		List<T> list = new ArrayList<>();
		for (int i = 0; i < max; ++i) {
			T value = uniqs.get(i);
			for (int j = 0, size = counts[i]; j < size; ++j)
				list.add(value);
		}
		callback.accept(list);
	}

	private void solve(int i, int total) {
		if (i >= max)
            found(counts, total);
		else
			for (int k = 0, size = sizes.get(i); k <= size; ++k) {
				counts[i] = k;
				solve(i + 1, total + k);
			}
	}

	public static <T> void allCombinations(List<T> elements, Consumer<List<T>> callback) {
		new AllCombinations<T>(elements, callback).solve(0, 0);
	}

	public static void main(String[] args) {
		allCombinations(Arrays.asList(1, 1, 2, 3), list -> {
			System.out.println(list);
		});
//		List<Character> elements = new ArrayList<>();
//		for (char c = 'a'; c <= 'z'; ++c)
//			elements.add(c);
//		int[] count = {0};
//		allCombinations(elements, list -> {
//			System.out.println("" + ++count[0] + " : " + list);
//		});
	}
}
