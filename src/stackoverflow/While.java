package stackoverflow;

public class While {

    public static void main(String[] args) {
        int x = 0;
        int flips = 0;
        int y = 0;
        int opponent = 0;
        int[][] board = new int[3][3];

        while( x + ++flips < 8 && board[x + flips][y] == opponent );
    }
}
