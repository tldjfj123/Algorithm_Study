package UBiiiii.Week14.BOJ2667;

/*
 * 단지번호붙이기
 * 처음부터 순차적으로 돌아가면서
 * 단지가 있으면 탐색하는 bfs
 */

import java.io.*;
import java.util.*;

public class Main {
  private static List<Integer> answer = new ArrayList<>();
  private static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
  private static int[][] map;
  private static boolean[][] isChecked;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    isChecked = new boolean[n][n];
    for (int i = 0; i < n; i++)
      map[i] = Arrays.stream(br.readLine().split("")).mapToInt(el -> Integer.parseInt(el)).toArray();

    for(int i=0;i<n;i++) {
      for(int j=0;j<n;j++)  {
        if(map[i][j]==1 && !isChecked[i][j])  bfs(i, j);
      }
    }
    answer.sort((a,b)->a-b);
    System.out.println(answer.size());
    for(int i : answer) System.out.println(i);
  }

  private static void bfs(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    int nx, ny, cnt = 0;
    int[] tmp;
    q.offer(new int[] { x, y });
    isChecked[x][y] = true;
    while (!q.isEmpty()) {
      cnt++;
      tmp = q.poll();
      for (int i = 0; i < 4; i++) {
        nx = tmp[0] + dx[i];
        ny = tmp[1] + dy[i];
        if (nx > -1 && nx < map.length && ny > -1 && ny < map.length && map[nx][ny] == 1 && !isChecked[nx][ny]) {
          isChecked[nx][ny] = true;
          q.offer(new int[] { nx, ny });
        }
      }
    }

    answer.add(cnt);
  }

}
