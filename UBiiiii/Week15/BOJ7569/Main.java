package UBiiiii.Week15.BOJ7569;

/*
 * 7569 토마토
 * 예전에 해봤던 토마토 문제에 z축이 생긴 문제 => 3차원 배열로 작성한 다음, z축에 대한 확인만 추가해주면 되는 BFS
 */

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m, h, total = 0, clear = 0, nx, ny, nz;
    int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 }, dz = { 1, -1 }, tmp = new int[4];
    int[][][] map;
    Queue<int[]> q = new LinkedList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    map = new int[h][n][m];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(el -> Integer.parseInt(el)).toArray();
        for (int k = 0; k < m; k++) {
          if (map[i][j][k] != -1)
            total++;

          if (map[i][j][k] == 1) {
            q.offer(new int[] { i, j, k, 0 });
            clear++;
          }
        }
      }
    }

    if (total == clear) {
      System.out.println(0);
      return;
    }

    while (!q.isEmpty()) {
      tmp = q.poll();
      for (int i = 0; i < 2; i++) {
        nz = tmp[0] + dz[i];
        if (nz > -1 && nz < h && map[nz][tmp[1]][tmp[2]] == 0) {
          clear++;
          map[nz][tmp[1]][tmp[2]] = 1;
          q.offer(new int[] { nz, tmp[1], tmp[2], tmp[3] + 1 });
        }
      }

      for (int i = 0; i < 4; i++) {
        nx = tmp[1]+dx[i];
        ny = tmp[2]+dy[i];
        if (nx > -1 && nx < n && ny > -1 && ny < m && map[tmp[0]][nx][ny] == 0) {
          clear++;
          map[tmp[0]][nx][ny] = 1;
          q.offer(new int[] { tmp[0], nx, ny, tmp[3] + 1 });
        }
      }
    }

    System.out.println(total==clear ? tmp[3] : -1);

  }

}
