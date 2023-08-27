package YeonChanLim.Week09.카카오프렌즈컬러링북;

/*
웃음이 나오네..ㅎㅎㅎ
인접한 영역 구하는거라 bfs라고 생각은 함
게임 맵 최단거리 보면서 짜보려고 했는데 무리데스...
참고 사이트 : https://tmdrl5779.tistory.com/194
https://blog.itcode.dev/posts/2021/12/26/programmers-a0067

BFS 알고리즘 - 너비 우선 탐색
- 너비를 중심으로 탐색
- 노드의 깊이가 얕을수록 유리
- Queue를 활용하여 구현
 */

import java.util.*;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        // 모든 좌표를 순회하며 탐색 시작
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                // 아직 방문하지 않았고, 색상이 0이 아닌 경우 영역 탐색 시작
                if(!visited[i][j] && picture[i][j] != 0){
                    // bfs 함수를 호출하여 영역의 크기를 구하고, 그 크기와 기존의 최대 영역 크기를 비교하여 갱신
                    maxSizeOfOneArea = Math.max(bfs(i, j, picture, visited, picture[i][j]), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int cx, int cy, int[][] graph, boolean[][] visited, int color){
        int count = 1;
        visited[cx][cy] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cx, cy});

        while (!queue.isEmpty()){
            int[] pop = queue.remove();
            int px = pop[0];
            int py = pop[1];

            // 상하좌우 인접한 좌표들을 탐색
            for (int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                // 그래프 범위를 벗어나거나 이미 방문한 좌표는 건너뜀
                if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length){
                    continue;
                }

                // 방문하지 않았고, 같은 색상인 경우 큐에 추가하고 영역 크기 증가 및 방문 처리
                if (!visited[nx][ny] && graph[nx][ny] == color) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
