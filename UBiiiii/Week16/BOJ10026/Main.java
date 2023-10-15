package BOJ10026;

import java.util.*;
import java.io.*;

public class Main {
  static int n, cnt;
  static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
  static char[][] map;
  static boolean[][] rgmap, isChecked;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(br.readLine());
    map = new char[n][n];
    rgmap = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      char[] input = br.readLine().toCharArray();
      map[i] = input;
      for (int j = 0; j < input.length; j++)
        rgmap[i][j] = input[j] == 'B';
    }

    cnt = 0;
    isChecked = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isChecked[i][j] == false) {
          bfs(i, j);
          cnt++;
        }
      }
    }
    sb.append(cnt).append(" ");

    cnt = 0;
    isChecked = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isChecked[i][j] == false) {
          rgbfs(i, j);
          cnt++;
        }
      }
    }
    sb.append(cnt);

    System.out.println(sb.toString());

  }

  private static int bfs(int x, int y) {
    int cnt = 0, nx, ny;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { x, y });
    isChecked[x][y] = true;
    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      for (int i = 0; i < 4; i++) {
        nx = tmp[0] + dx[i];
        ny = tmp[1] + dy[i];
        if (nx > -1 && nx < n && ny > -1 && ny < n && !isChecked[nx][ny] && map[nx][ny] == map[x][y]) {
          isChecked[nx][ny] = true;
          q.offer(new int[] { nx, ny });
        }
      }
    }

    return cnt;
  }

  private static int rgbfs(int x, int y) {
    int cnt = 0, nx, ny;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { x, y });
    isChecked[x][y] = true;
    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      for (int i = 0; i < 4; i++) {
        nx = tmp[0] + dx[i];
        ny = tmp[1] + dy[i];
        if (nx > -1 && nx < n && ny > -1 && ny < n && !isChecked[nx][ny] && rgmap[nx][ny] == rgmap[x][y]) {
          isChecked[nx][ny] = true;
          q.offer(new int[] { nx, ny });
        }
      }
    }

    return cnt;
  }
}
