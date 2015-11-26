package stackoverflow;

import java.util.Arrays;

public class MathRand {

    public static void main(String[] args) {
        String t = "([S Creatine]+[b.gfr])-0.32+[c,gd]*1000,00";
        System.out.println(t.replaceAll("[.,](?=[^\\[]*\\])", ""));

        String s = "(123)+\t3 - 2";
        System.out.println(s.matches("[\\d\\s()+-]+"));
        int[] count = new int[3];
        for (int i = 0; i < 10; ++i)
            ++count[(int)(Math.random() * 3)];
        System.out.println(Arrays.toString(count));
    }
}
