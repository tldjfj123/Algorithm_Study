package 헌내기는친구가필요해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static String[][] arr;
    public static boolean[][] visited;
    public static int[] dx;
    public static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];
        visited = new boolean[n][m];

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("I")) {
                    int calc = bfs(i, j);

                    if (calc == 0) {
                        System.out.println("TT");
                    } else {
                        System.out.println(calc);
                    }
                }
            }
        }

    }

    public static int bfs(int x, int y) {
        int metPeople = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] v = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + v[0];
                int ny = dy[i] + v[1];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && !arr[nx][ny].equals("X")) {
                    if (arr[nx][ny].equals("P")) {
                        metPeople++;
                    }
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return metPeople;


    }
}
