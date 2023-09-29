package YeonChanLim.Week14.색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int N;
    static int whiteCnt = 0;
    static int blueCnt = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findCnt(0, 0, N);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);

        br.close();

    }
    public static void findCnt(int x, int y, int size) {
            if (colorCheck(x, y, size)) {
                if (board[x][y] == 1) {
                    blueCnt++;
                } else {
                    whiteCnt++;
                }
            } else {
                int halfSize = size / 2;

                int[] sx = { x, x, x + halfSize, x + halfSize };
                int[] sy = { y, y + halfSize, y, y + halfSize };

                for (int i = 0; i < 4; i++) {
                    findCnt(sx[i], sy[i], halfSize);
                }
            }
    }
    public static boolean colorCheck(int x, int y, int size) {
        if(size == 1) {
            return true;
        }

        int color = board[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
