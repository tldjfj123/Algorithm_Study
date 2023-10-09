package 토마토7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 특정 지점에서 시작이 아닌 1인 모든 지역들 다 queue에 추가함
 * bfs 돌면서 익는 값 = 전에 값 + 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        boolean notChanged = true;
        boolean noStart = true;
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
                if (board[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    notChanged = false;
                    noStart = false;
                }
            }
        }

        if (noStart) {
            System.out.println(-1);
        } else {
            while (!queue.isEmpty()) {
                int[] v = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = v[0] + dx[i];
                    int ny = v[1] + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (board[nx][ny] == 0) {
                            queue.add(new int[] {nx, ny});
                            board[nx][ny] = board[v[0]][v[1]] + 1;
                        }
                    }

                }
            }

            //원래 다 익어있는 경우
            if (notChanged) {
                System.out.println(0);
            } else {
                boolean failed = false;
                int result = 0;

                //전체 돌면서 안익은 토마토 & 최댓값 구하기
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (board[i][j] == 0) {
                            failed = true;
                            break;
                        } else {
                            if (board[i][j] > result) {
                                result = board[i][j];
                            }
                        }
                    }
                }
                if (failed) {
                    System.out.println(-1);
                } else {
                    System.out.println(result - 1);
                }
            }
        }
    }
}
