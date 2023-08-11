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

        /*
        각 문제마다 점수 업데이트
        4점을 기준으로 4점보다 작으면 문제의 앞 유형, 크면 뒷 유형 점수 추가
        비교할 유형들끼리 비교해서 최종 출력
        */
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