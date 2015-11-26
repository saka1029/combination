package stackoverflow;

public class MultLong {

    public static void main(String[] args) {
        long m = 24 * 60 * 60 * 1000 * 1000;
        long m2 = 24L * 60 * 60 * 1000 * 1000;
        long m3 = 24 * 60 * 60 * 1000 * 1000L;
        System.out.printf("m=%d m2=%d m3=%d%n", m, m2, m3);
    }
}
