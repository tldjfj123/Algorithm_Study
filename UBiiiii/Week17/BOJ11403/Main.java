package BOJ11403;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Queue<int[]> q = new LinkedList<>();
    int n = Integer.parseInt(br.readLine());
    int[][] edges = new int[n][n];
    int[][] answer = new int[n][n];
    for(int i=0;i<n;i++) {
      edges[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(el->Integer.parseInt(el)).toArray();
      for(int j=0;j<n;j++) if(edges[i][j]==1)
        q.offer(new int[] {i, j});
    }

    while(!q.isEmpty()) {
      int[] curr = q.poll();
      answer[curr[0]][curr[1]] = 1;
      if(curr[0]==curr[1])  continue;
      for(int i=0;i<n;i++)  if(edges[curr[1]][i]==1&&answer[curr[0]][i]==0)  q.offer(new int[] {curr[0], i});
    }

    for(int i=0;i<n;i++)  {
      for(int j=0;j<n;j++) {
        sb.append(answer[i][j]).append(j!=n-1?" ":"");
      }
      if(i!=n-1)  sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
