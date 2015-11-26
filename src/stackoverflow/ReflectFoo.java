package stackoverflow;

import java.util.Arrays;

public class ReflectFoo {

    static class Foo {
        public void test() {
            
        }
    }
    
    public static void main(String[] args) {
        Class<Foo> c = Foo.class;
        System.out.println(Arrays.toString(c.getDeclaredMethods()));
    }
}
