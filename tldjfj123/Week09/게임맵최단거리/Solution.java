package 게임맵최단거리;

import java.util.*;

/**
 * 최단거리 길찾기? -> BFS!
 */
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        //안넘어가게 limit 설정
        int rowLimit = maps.length;
        int columnLimit = maps[0].length;

        boolean[][] visited = new boolean[rowLimit][columnLimit];
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            if (v[0] == rowLimit - 1 && v[1] == columnLimit - 1) { //끝점에 도달한 경우
                return maps[rowLimit - 1][columnLimit - 1];
            }

            for (int i = 0; i < 4; i++) { // 4방향으로 돌면서 bfs 수행
                int calcX = dx[i] + v[0];
                int calcY = dy[i] + v[1];

                if (calcX >= 0 && calcX < rowLimit && calcY >= 0 && calcY < columnLimit && maps[calcX][calcY] == 1 && !visited[calcX][calcY]) {
                    queue.offer(new int[]{calcX, calcY});
                    visited[calcX][calcY] = true;
                    maps[calcX][calcY] = maps[v[0]][v[1]] + 1; // 거리계산위해 진행할때 마다 1씩 더해나감
                }
            }
        }

        return -1;
    }
}
