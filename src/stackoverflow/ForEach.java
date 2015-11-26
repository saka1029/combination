package stackoverflow;

import java.util.function.Consumer;

public class ForEach {
	
	public static void main(String[] args) {
        Container<Fish> fishies = new Container<>();
        fishies.add(new Fish("Cod"));
        fishies.add(new Fish("Salmon"));
        fishies.forEach(System.out::println);
	}

}

class Fish {
    final String name;
    Fish(String name) { this.name = name; }
    @Override public String toString() { return name; }
}

class Container<T> {

    int size = 0;
    Object[] array = new Object[200]; 
    
    public void add(T e) {
        array[size++] = e;
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < size; ++i)
            consumer.accept((T)array[i]);
    }
}
