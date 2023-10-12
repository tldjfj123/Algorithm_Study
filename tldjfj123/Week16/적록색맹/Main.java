package 적록색맹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] possible = new char[n][n]; //정상
        char[][] impossible = new char[n][n]; //색약

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] colors = {'R', 'G', 'B'};

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                possible[i][j] = s.charAt(j);
                impossible[i][j] = s.charAt(j);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int res1 = 0;
        //정상인 기준
        for (char c : colors) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (possible[i][j] == c) {
                        queue.add(new int[] {i, j});
                        res1++;

                        while (!queue.isEmpty()) {
                            int[] v = queue.poll();

                            for (int k = 0; k < 4; k++) {
                                int nx = v[0] + dx[k];
                                int ny = v[1] + dy[k];

                                if (0 <= nx && nx < n && 0 <= ny && ny < n && possible[nx][ny] == c) {
                                    queue.add(new int[] {nx, ny});
                                    possible[nx][ny] = 'A';

                                }
                            }
                        }
                    }
                }
            }
        }

        int res2 = 0;
        //색약 기준
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (impossible[i][j] == 'B') { // 그냥 구분됨
                    queue.add(new int[] {i, j});
                    res2++;

                    while (!queue.isEmpty()) {
                        int[] v = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = v[0] + dx[k];
                            int ny = v[1] + dy[k];

                            if (0 <= nx && nx < n && 0 <= ny && ny < n && impossible[nx][ny] == 'B') {
                                queue.add(new int[] {nx, ny});
                                impossible[nx][ny] = 'A';
                            }
                        }
                    }
                } else if (impossible[i][j] == 'G') {
                    queue.add(new int[] {i, j});
                    res2++;

                    while (!queue.isEmpty()) {
                        int[] v = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = v[0] + dx[k];
                            int ny = v[1] + dy[k];

                            if (0 <= nx && nx < n && 0 <= ny && ny < n && (impossible[nx][ny] == 'G' || impossible[nx][ny] == 'R')) {
                                queue.add(new int[] {nx, ny});
                                impossible[nx][ny] = 'A';
                            }
                        }
                    }
                } else if (impossible[i][j] == 'R') {
                    queue.add(new int[] {i, j});
                    res2++;

                    while (!queue.isEmpty()) {
                        int[] v = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = v[0] + dx[k];
                            int ny = v[1] + dy[k];

                            if (0 <= nx && nx < n && 0 <= ny && ny < n && (impossible[nx][ny] == 'G' || impossible[nx][ny] == 'R')) {
                                queue.add(new int[] {nx, ny});
                                impossible[nx][ny] = 'A';
                            }
                        }
                    }

                }

            }
        }
        System.out.println(res1 + " " + res2);
    }
}
