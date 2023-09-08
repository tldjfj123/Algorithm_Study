package BOJ1012;

/*
 * 인접한 배추들의 구역을 세자 -> bfs를 이용하자
 * map, isChecked는 boolean 배열로 구성 -> int를 써도 되는데, 이게 메모리가 더 적지 않을까?
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, nx, ny;
    private static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1 ,0};
    private static boolean[][] map, isChecked;
    private static Queue<int[]> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t, k, x, y, cnt;
        t = Integer.parseInt(br.readLine());
        for(int cn=0;cn<t;cn++) {
            // bfs를 위한 큐 초기화
            q = new LinkedList<>();

            // 입력에 대한 맵 구성
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cnt = 0;
            map = new boolean[m][n];
            isChecked = new boolean[m][n];

            for(int i=0;i<k;i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y] = true;
            }

            // 각 영역에 대한 bfs
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(map[i][j] && !isChecked[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        int[] tmp;
        q.offer(new int[] {x, y});
        isChecked[x][y] = true;
        while(!q.isEmpty()) {
            tmp = q.poll();
            for(int i=0;i<4;i++) {
                nx = tmp[0]+dx[i];
                ny = tmp[1]+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && map[nx][ny] && !isChecked[nx][ny]) {
                    isChecked[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
