package 바탕화면정리;

import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {wallpaper.length, wallpaper[0].length(), 0, 0};
        for(int i=0;i<wallpaper.length;i++) {
            String[] row = wallpaper[i].split("");
            for(int j=0;j<row.length;j++) {
                if(row[j].equals("#")) {
                    if(i<answer[0]) answer[0] = i;
                    if(i>=answer[2]) answer[2] = i+1;
                    if(j<answer[1]) answer[1] = j;
                    if(j>=answer[3]) answer[3] = j+1;
                }
            }
        }
        return answer;
    }
}