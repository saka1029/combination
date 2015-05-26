package combination;

import java.util.ArrayList;
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

//	public static <T> Set<List<T>> allCombinations(List<T> elements) {
//		Set<List<T>> result = new HashSet<>();
//		for (int k = 1, size = elements.size(); k <= size; ++k)
//			combination(elements, k, result);
//		return result;
//	}

//	public static void testAllCombinations() {
//		List<Character> elements = new ArrayList<>();
//		for (char i = 'a'; i <= 'd'; ++i)
//			elements.add(i);
//		Set<List<Character>> result = allCombinations(elements);
//		System.out.printf("size=%s result=%s%n", result.size(), result);
//	}

	public static void testCombination() {
		List<Character> elements = new ArrayList<>();
		for (char i = 'a'; i <= 'y'; ++i)
			elements.add(i);
		combination(elements, 5, x -> { System.out.println(x); });
	}
		
	public static void main(String[] args){
		testCombination();
	}
	
}