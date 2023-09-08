package YeonChanLim.Week11.유기농배추;

/*
인접하다니까 dfs/bfs 생각..
상하좌우 이동한다니까 dx, dy
배추가 나오는 경우에만 탐색!
근데... 코드 짜는게 너무 어렵네요 하핳
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {

    static int M, N, K;
    static int[][] cabbage;
    static boolean[][] visit;
    static int count;

    // 상하좌우 이동을 위한 배열
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    static void bfs(int x, int y) {
        Queue<int[]> qu = new LinkedList<int[]>();
        qu.add(new int[] { x, y });

        while (!qu.isEmpty()) {
            x = qu.peek()[0];
            y = qu.peek()[1];
            visit[x][y] = true;
            qu.poll();
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                // 배열 범위를 벗어나지 않고, 아직 방문하지 않은 배추를 찾으면 큐에 추가하고 방문 표시
                if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                    if (!visit[cx][cy] && cabbage[cx][cy] == 1) {
                        qu.add(new int[] { cx, cy });
                        visit[cx][cy] = true;
                    }
                }

            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int c = 0; c < T; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cabbage = new int[M][N];
            visit = new boolean[M][N];
            count=0;

            for (int i = 0; i < K; i++) {
                st=new StringTokenizer(br.readLine()," ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                cabbage[p1][p2] = 1;

            }

            // 모든 배추를 순회하며 아직 방문하지 않은 배추 그룹을 찾고 개수
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (cabbage[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
}
