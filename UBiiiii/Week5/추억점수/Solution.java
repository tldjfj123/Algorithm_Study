package 추억점수;

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int idx = 0;
        for(String[] members : photo) {
            int score = 0;
            for(String member: members) {
                if(Arrays.asList(name).contains(member))   score += yearning[Arrays.asList(name).indexOf(member)];
            }
            answer[idx++] = score;
        }
        return answer;
    }
}