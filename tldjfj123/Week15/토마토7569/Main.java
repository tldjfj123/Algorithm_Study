package 토마토7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 행
        int n = Integer.parseInt(st.nextToken()); // 열
        int h = Integer.parseInt(st.nextToken()); // 층

        int[][][] board = new int[h][n][m];
        Queue<int []> queue = new LinkedList<>();
        int[] dx = {0, 0, 0, 0, -1, 1};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {-1, 1, 0, 0, 0, 0};

        boolean notChanged = true;
        boolean noStart = true;

        //배열 선언부
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                        notChanged = false;
                        noStart = false;
                    }
                }
            }
        }

        if (noStart) {
            System.out.println(-1);
            return;
        } else {
            while (!queue.isEmpty()) {
                int[] v = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int nz = v[0] + dz[i];
                    int nx = v[1] + dx[i];
                    int ny = v[2] + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m && 0 <= nz && nz < h && board[nz][nx][ny] == 0) {
                        queue.add(new int[] {nz, nx, ny});
                        board[nz][nx][ny] = board[v[0]][v[1]][v[2]] + 1;
                    }
                }
            }
        }

        if (notChanged) {
            System.out.println(0);
        } else {
            boolean failed = false;
            int res = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (board[i][j][k] == 0) {
                            failed = true;
                            break;
                        } else {
                            if (board[i][j][k] > res) {
                                res = board[i][j][k];
                            }
                        }
                    }
                }
            }
            if (failed) {
                System.out.println(-1);
            } else {
                System.out.println(res - 1);
            }

        }

    }
}
