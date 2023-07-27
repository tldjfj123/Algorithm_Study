package 공원산책;

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        String[][] map = new String[park.length][];
        int[] answer = {};
        int h, w;
        
        for(int i=0;i<park.length;i++) {
            map[i] = park[i].split("");
            for(int j=0;j<map[i].length;j++) {
                if(map[i][j].equals("S"))    answer = new int[] { i,j };
            }
        }
        
        h = map.length;
        w = map[0].length;
        
        for(String route: routes) answer = check(map, answer, route, h, w);
        
        return answer;
    }
    
    static int[] check(String[][] map, int[] pos, String route, int h, int w) {        
        String[] r = route.split(" ");
        String[] dir = {"N", "E", "S", "W"};
        int[] y = {-1, 0, 1, 0};
        int[] x = {0, 1, 0, -1};
        
        int idx = Arrays.asList(dir).indexOf(r[0]);
        
        for(int i=1; i <= Integer.parseInt(r[1]); i++) {
            int[] newPos = new int[] {pos[0]+y[idx]*i, pos[1]+x[idx]*i};
            if(newPos[0]<0 || newPos[0]==h || newPos[1]<0 || newPos[1]==w || map[newPos[0]][newPos[1]].equals("X")) return pos;
        }
        
        return new int[] {pos[0] + y[idx]*Integer.parseInt(r[1]), pos[1] + x[idx]*Integer.parseInt(r[1])};
    }
}