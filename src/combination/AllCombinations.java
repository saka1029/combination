package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

	private AllCombinations(List<T> elements) {
		this(elements, null);
	}

	private List<T> result() {
		List<T> list = new ArrayList<>();
		for (int i = 0; i < max; ++i) {
			T value = uniqs.get(i);
			for (int j = 0, size = counts[i]; j < size; ++j)
				list.add(value);
		}
		return list;
	}
	private void found(int total) {
//		System.out.println("answer=" + Arrays.toString(counts));
		if (total <= 0) return;
		List<T> list = result();
		callback.accept(list);
	}

	private void solve(int i, int total) {
		if (i >= max)
            found(total);
		else
			for (int k = 0, size = sizes.get(i); k <= size; ++k) {
				counts[i] = k;
				solve(i + 1, total + k);
			}
	}

	public static <T> void allCombinations(List<T> elements, Consumer<List<T>> callback) {
		new AllCombinations<T>(elements, callback).solve(0, 0);
	}
	
	public static <T> Iterator<List<T>> iterator(List<T> elements) {
		return new Iterator<List<T>>() {
			
			AllCombinations<T> a = new AllCombinations<>(elements);

			@Override
			public boolean hasNext() {
				for (int i = 0; i < a.max; ++i)
					if (a.counts[i] < a.sizes.get(i))
						return true;
				return false;
			}

			List<T> found(int index) {
				++a.counts[index];
				return a.result();
			}

			@Override
			public List<T> next() {
				for (int i = 0; i < a.max; ++i)
					if (a.counts[i] < a.sizes.get(i))
						return found(i);
					else
						a.counts[i] = 0;
				throw new NoSuchElementException();
			}
		};
	}

	public static <T> Iterable<List<T>> iterable(List<T> elements) {
		return new Iterable<List<T>>() {
			@Override
			public Iterator<List<T>> iterator() {
				return AllCombinations.iterator(elements);
			}
		};
	}

	public static <T> Stream<List<T>> stream(List<T> elements) {
		return StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(iterator(elements), Spliterator.ORDERED),
            false);
	}
	
	public static void main(String[] args) {
		List<Integer> elements = Arrays.asList(1, 1, 2, 3);
		System.out.println("---- callback ----");
		AllCombinations.allCombinations(elements, list -> {
			System.out.println(list);
		});
		System.out.println("---- iterator ----");
		Iterator<List<Integer>> it = AllCombinations.iterator(elements);
		while (it.hasNext())
			System.out.println(it.next());

		System.out.println("---- iterable ----");
		for (List<Integer> list : AllCombinations.iterable(elements))
			System.out.println(list);

		System.out.println("---- stream ----");
		AllCombinations.stream(elements)
			.forEach(System.out::println);
	}
}
