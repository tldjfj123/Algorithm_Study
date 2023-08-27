package 카카오프렌즈컬러링북;

import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int rowLimit = m;
        int columnLimit = n;
        boolean[][] visited = new boolean[rowLimit][columnLimit];

        for (int i = 0; i < rowLimit; i++) {
            for (int j = 0; j < columnLimit; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int tmp = 1;

                    while (!queue.isEmpty()) {
                        int[] v = queue.poll();
                        int std = picture[v[0]][v[1]];

                        for (int k = 0; k < 4; k++) {
                            int calcX = dx[k] + v[0];
                            int calcY = dy[k] + v[1];

                            if (calcX >= 0 && calcX < rowLimit && calcY >= 0 && calcY < columnLimit && picture[calcX][calcY] == std && !visited[calcX][calcY]) {
                                queue.offer(new int[]{calcX, calcY});
                                visited[calcX][calcY] = true;
                                tmp++; // 탐색 시작점과 같은 숫자이고 범위 내에 있는 경우에만++,
                            }
                        }
                    }

                    numberOfArea++; // 한번 연산 = 영역 1개
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmp); // 최댓값 갱신
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }
}
