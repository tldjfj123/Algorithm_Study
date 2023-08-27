package UBiiiii.Week9.lv2.카카오프렌즈컬러링북;

import java.util.*;

class Solution {
    static int[] tmp, dx = {0, 1, 0, -1}, dy = {1, 0, -1 ,0};
    static boolean[][] isChecked = {};
    static Queue<int[]> queue = new LinkedList<>();
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0, maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        
        isChecked = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(picture[i][j]!=0&&!isChecked[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture[i][j], picture));
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private static int bfs(int x, int y, int n, int[][] picture) {
        int nx=0, ny=0, tmpSize=0;
        queue.offer(new int[] {x, y});
        isChecked[x][y] = true;
        while(!queue.isEmpty()) {
            tmp = queue.poll();
            tmpSize++;
            for(int i=0;i<4;i++) {
                nx = tmp[0] + dx[i];
                ny = tmp[1] + dy[i];
                if(nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length || isChecked[nx][ny] || picture[nx][ny]!=n)   continue;
                isChecked[nx][ny]=true;
                queue.offer(new int[] {nx, ny});
            }
        }
        
        return tmpSize;
    }
}
