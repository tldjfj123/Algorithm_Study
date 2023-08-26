package YeonChanLim.Week09.게임맵최단거리;

/*
bfs/dfs는 아직 제대로 안 잡혀있어서 바로 검색을 통한 이해모드로..
참고 사이트 : https://blackvill.tistory.com/177

BFS기초-Queue를 알아햐 해결 가능..

풀이 순서
1. 4방 탐색을 위한(동,서,남,북) dx, dy 배열
2. 방문체크를 위한 배열
3. 시작위치를 1로 지정하고 방문체크
4. bfs 탐색
5. 범위를 벗어나는지, 방문 했는지, 갈 수 있는 곳인지 확인
6. 확인 후 문제가 없으면 해당 위치까지 방문한 수 + 1
7. bfs 추가적 탐색
8. 결과 answer
9. answer이 0이면 도착 할 수 없는 곳이니까 -1
10. 결과

p.s 주석 추가 예정
 */

import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];

        // 시작위치 방문 check
        visited[0][0] = 1;

        // bfs 탐색
        bfs(maps, visited);
        // 도착지 값
        answer = visited[maps.length -1][maps[0].length - 1];

        // 갈 수 없다면 -1
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
    public void bfs(int[][] maps, int[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < 4; i++){
                // 이동했을 때 위치
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 벗어나는지, 방문했는지, 갈 수 있는지 확인
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length
                        && visited[nx][ny] == 0 && maps[nx][ny] == 1){
                    // 방문했다고 체크
                    visited[nx][ny] = visited[x][y] + 1;
                    // 큐에 넣기
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
