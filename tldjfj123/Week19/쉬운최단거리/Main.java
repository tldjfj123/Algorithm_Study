package 쉬운최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최단거리 -> bfs!
 */

public class Main {
    static int n;
    static int m;
    static int[] dx;
    static int[] dy;
    static int[][] arr;
    static boolean[][] visited;

    public static void bfs(int goalX, int goalY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {goalX, goalY});
        visited[goalX][goalY] = true;

        while (!queue.isEmpty()) {
            int[] v = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + v[0];
                int ny = dy[i] + v[1];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] != 0 && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[v[0]][v[1]] + 1;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};

        arr = new int[n][m];

        int goalX = 0;
        int goalY = 0;

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                if (arr[i][j] == 2) {
                    goalX = i;
                    goalY = j;
                } else if(arr[i][j] == 1) {
                    arr[i][j] = -1;
                }
            }
        }

        visited = new boolean[n][m];
        arr[goalX][goalY] = 0;

        bfs(goalX, goalY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


}
