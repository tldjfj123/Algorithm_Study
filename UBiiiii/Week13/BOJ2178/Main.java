package BOJ2178;

/*
 * 미로탐색
 * 간단한 bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m, nx, ny;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1 ,0};
        int[][] map;
        boolean[][] isChecked;
        Queue<int[]> q;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isChecked = new boolean[n][m];
        q = new PriorityQueue<>(n*m, (a,b)->a[2]-b[2]);

        for(int i=0;i<n;i++) {
            String input = br.readLine();
            for(int j=0;j<m;j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        q.offer(new int[] {0, 0, 1});
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            if(curr[0]==n-1&&curr[1]==m-1) {
                System.out.println(curr[2]);
                return;
            }

            if(isChecked[curr[0]][curr[1]]) continue;
            isChecked[curr[0]][curr[1]] = true;

            for(int i=0;i<4;i++) {
                nx = curr[0] + dx[i];
                ny = curr[1] + dy[i];
                if(nx > -1 && nx < n && ny > -1 && ny < m && map[nx][ny]==1) {
                    q.offer(new int[] {nx, ny, curr[2]+1});
                }
            }
        }
    }
}
