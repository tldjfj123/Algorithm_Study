package UBiiiii.Week9.lv2.게임뱁최단거리;

import java.util.*;

class Solution {
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static Queue<Sell> q = new LinkedList<>();
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        q.offer(new Sell(0, 0, 1));
        
        while(!q.isEmpty()) {
            Sell tmp = q.poll();
            
            if(tmp.x==m-1 && tmp.y==n-1)    return tmp.len;
        
            for(int i=0; i<4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx < 0 || nx > m-1
                   || ny < 0 || ny > n-1
                   || maps[ny][nx] == 0
                  )  continue;
                maps[ny][nx] = 0;
                q.offer(new Sell(nx, ny, tmp.len+1));
            }
        }

        return -1;
    }
    
    private static class Sell {
        int x, y, len;
        
        public Sell(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}