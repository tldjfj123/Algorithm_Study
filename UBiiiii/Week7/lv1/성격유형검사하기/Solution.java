package UBiiiii.Week7.lv1.성격유형검사하기;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<Character, Integer> score = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int tmp, idx;
        int[] scores = new int[8];
        score.put('R', 0);
        score.put('T', 1);
        score.put('C', 2);
        score.put('F', 3);
        score.put('J', 4);
        score.put('M', 5);
        score.put('A', 6);
        score.put('N', 7);
        for(int i=0;i<survey.length;i++) {
            tmp = choices[i]-4;
            idx = tmp<0 ? score.get(survey[i].charAt(0)) : score.get(survey[i].charAt(1));
            scores[idx] += Math.abs(tmp);
        }

        answer.append(scores[0]<scores[1] ? "T" : "R")
            .append(scores[2]<scores[3] ? "F" : "C")
            .append(scores[4]<scores[5] ? "M" : "J")
            .append(scores[6]<scores[7] ? "N" : "A");
        return answer.toString();
    }
}