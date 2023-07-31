package YeonChanLim.Week05.바탕화면정리;

import java.lang.Math;

public class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int up, down, left, right;

        left = up = 49;
        right = down = 0;

        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){

                if(wallpaper[i].charAt(j) == '#'){
                    left = Math.min(left, j);
                    up = Math.min(up, i);
                    right = Math.max(right, j);
                    down = Math.max(down, i);
                }
            }
        }

        answer[0] = up;
        answer[1] = left;
        answer[2] = down+1;
        answer[3] = right+1;

        return answer;
    }
}
