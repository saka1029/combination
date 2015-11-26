package stackoverflow;

import java.util.Arrays;

public class Exponent {

    private static Game game;

    public static void main(String[] args) {

        double[] JagerList = { -5.0, -4.0, -3.0, -2.0, -1.0, -1.0/2.0, -1.0/3.0, -1.0/4.0, 0, 1.0/4.0, 1.0/3.0, 1.0/2.0, 1.0, 2.0, 3.0, 4.0, 5.0 };
        double[] exponent = new double[JagerList.length];
        for (int i = 0, size = JagerList.length; i < size; ++i)
            exponent[i] = Math.pow(i + 1, 4.0);
        System.out.println("JagerList=" + Arrays.toString(JagerList));
        System.out.println("exponent=" + Arrays.toString(exponent));
        
        System.out.println(game.y);
    }
    
    static class Game {
        static final int y = 3;
    }
    
}
