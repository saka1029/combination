package puzzle.util;

public class NQueens {

    static final int MAXSIZE = 256;

    static int[] board = new int[MAXSIZE];
    static int size;
    static int count;

    static String bin(int i) {
        String b = Integer.toBinaryString(i);
        while (b.length() < size)
            b = "0" + b;
        b = b.replaceAll("0", ".");
        b = b.replaceAll("1", "*");
        return b;
    }

    static void queen(int n, int right, int left) {
        if (n == size) {
            count++;
            for (int i = 0; i < size; ++i)
                System.out.println(bin(board[i]));
            System.out.println();
        } else {
            int used = right | left;
            for (int i = n; i < size; i++) {
                int bit = board[i];
                if ((bit & used) != 0)
                    continue;
                board[i] = board[n];
                board[n] = bit;
                queen(n + 1, (right | bit) >> 1, (left | bit) << 1);
                board[n] = board[i];
                board[i] = bit;
            }
        }
    }

    public static void main(String[] args) {
        int i;
        /* 初期化 */
        for (size = 8; size <= 8; size++) {
            for (i = 0; i < size; i++)
                board[i] = 1 << i;
            long startTime = System.nanoTime();
            long start = System.currentTimeMillis();
            count = 0;
            queen(0, 0, 0);
            System.out.printf("%d --> %d, 時間 %dms %sms%n", size, count,
                    System.currentTimeMillis() - start, (System.nanoTime() - startTime) / 1000000);
        }
    }
}
