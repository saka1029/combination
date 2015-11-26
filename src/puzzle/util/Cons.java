package puzzle.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class Cons<T> implements Iterable<T> {

	public final T head;
	public final Cons<T> tail;

	private Cons(T head, Cons<T> tail) {
		if (head == null || head == nil())
			throw new IllegalArgumentException("head must not be nil");
		this.head = head;
		this.tail = tail;
	}
	
	public T get(int i) {
		if (i < 0) throw new IndexOutOfBoundsException("i");
		return i == 0 ? head : tail.get(i - 1);
	}

	public int size() {
		return this == nil() ? 0 : tail.size() + 1;
	}
	
	public List<T> toList() {
		List<T> result = new ArrayList<>();
		for (Cons<T> c = this; c != nil(); c = c.tail)
			result.add(c.head);
		return result;
	}
	
	public Stream<T> stream() {
		Builder<T> builder = Stream.builder();
		for (Cons<T> c = this; c != nil(); c = c.tail)
			builder.add(c.head);
		return builder.build();
	}

	private static final Cons<Object> NIL = new Cons<Object>(new Object(), null) {
		public String toString() { return "nil"; }
	};

	@SuppressWarnings("unchecked")
	public static <T> Cons<T> nil() {
		return (Cons<T>)NIL;
	}
	
	public static <T> Cons<T> cons(T head, Cons<T> tail) {
		if (tail == null)
			throw new IllegalArgumentException("tail must not be nill");
		return new Cons<>(head, tail);
	}
	
	private static <T> Cons<T> listFrom(int i, T[] values) {
		if (i >= values.length)
			return nil();
		else
			return new Cons<>(values[i], listFrom(i + 1, values));
	}

	@SafeVarargs
	public static <T> Cons<T> list(T... values) {
		return listFrom(0, values);
	}
	
	public static <T> Cons<T> list(List<T> list) {
		Cons<T> result = nil();
		for (int i = list.size() - 1; i >= 0; --i)
			result = cons(list.get(i), result);
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		Cons<T> c = this;
		String sep = "";
		do {
			sb.append(sep).append(c.head);
			sep = ", ";
			c = c.tail;
		} while (c != nil());
		sb.append(")");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cons))
			return false;
		if (this == obj)
			return true;
		@SuppressWarnings("unchecked")
		Cons<T> o = (Cons<T>)obj;
		return o.head.equals(this.head) && o.tail.equals(this.tail);
	}
	
	@Override
	public int hashCode() {
		int r = head.hashCode();
		for (Cons<T> c = this; c != nil(); c = c.tail)
			r ^= c.head.hashCode();
		return r;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			Cons<T> cons = Cons.this;

			@Override
			public boolean hasNext() {
				return cons != nil();
			}

			@Override
			public T next() {
				T r = cons.head;
				cons = cons.tail;
				return r;
			}
		};
	}
	
}
