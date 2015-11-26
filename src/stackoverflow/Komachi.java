package stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Komachi {

	static <T> List<T> cons(T head, List<T> tail) {
		List<T> list = new ArrayList<>();
		list.add(head);
		list.addAll(tail);
		return list;
	}

	static Stream<List<String>> split(String s) {
		if (s.length() <= 0)
			return Stream.of(Arrays.asList());
		Stream<List<String>> b = Stream.empty();
		for (int i = 1, size = s.length(); i <= size; ++i) {
			String head = s.substring(0, i);
			b = Stream
					.concat(b,
							split(s.substring(i)).flatMap(
									l -> Stream.of(cons(head, l),
											cons("-" + head, l))));
		}
		return b;
	}

	static void q5() {
		splitList("123456789")
				.stream()
				.filter(l -> l.stream().map(s -> Integer.parseInt(s))
						.reduce(0, (a, b) -> a + b) == 100)
				.forEach(l -> System.out.println(l));
	}

	// ストリームではなくリストのリストを返す場合は以下のようになります。

	static List<List<String>> splitList(String s) {
		if (s.length() <= 0)
			return Arrays.asList(Arrays.asList());
		List<List<String>> b = new ArrayList<>();
		for (int i = 1, size = s.length(); i <= size; ++i) {
			String head = s.substring(0, i);
			for (List<String> l : splitList(s.substring(i))) {
				b.add(cons(head, l));
				b.add(cons("-" + head, l));
			}
		}
		return b;
	}

	public static void main(String[] args) {
		foo();
		// List<List<String>> list = splitList("123456789");
		// int count = 0;
		// for (List<String> e : list)
		// System.out.println(++count + " " + e);
	}

//	void Seq() {
//		 int [][]arr = new int[3][3];
//		 int []input2 = {1,2,3,4,1,2,3,4,1,2,3,4};
//		 for(int i=0; i< arr.length; i++) {
//			 for(int j=0; j<arr[i].length; j++) {
//				 //System.out.println("index" + ((iarr.length) + j) );
//				 arr[i][j] = input2[(iarr.length) + j];
//				 System.out.print(" " + arr[i][j]);
//			 }
//			 System.out.println();
//			 } 
//			 }
//		 }
//	}
	static final String[] GLOBAL_HTML_ATTRIBUTES = {
		"accesskey", "class", "contenteditable", "contextmenu", "dir", "draggable",
		"dropzone", "hidden", "id", "lang", "spellcheck", "style", "tabindex",
		"title", "translate"};

	static final String[] A_ELEMENT_ATTRIBUTES = {
		"download", "href", "hreflang", "media", "name", "rel", "target", "type"};

    static final String[] attributes = Stream.concat(
        		Stream.of(GLOBAL_HTML_ATTRIBUTES),
        		Stream.of(A_ELEMENT_ATTRIBUTES))
        	.collect(Collectors.toList()).toArray(new String[]{});

    static void foo() {
        System.out.println(Arrays.toString(attributes));
	}
    
    interface Gauge<T> {}
    public class CachedGauge<T> implements Gauge<T> {

    	final Supplier<T> supplier;

        public CachedGauge(int timeout, TimeUnit minutes, Supplier<T> supplier) {
        	this.supplier = supplier;
		}

		protected T loadValue() {
            return supplier.get();
        }
    }

    void bar() {
        CachedGauge<Integer> cg = new CachedGauge<Integer>(
        	1, TimeUnit.MINUTES, () -> 1
        );

    }

}
