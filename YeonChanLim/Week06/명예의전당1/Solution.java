package YeonChanLim.Week06.명예의전당1;

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (i < k-1){
                temp.add(score[i]);
                // 임시 ArrayList를 내림차순으로 정렬
                temp.sort(Collections.reverseOrder());
                // 마지막 요소를 answer배열에 저장
                answer[i]=temp.get(temp.size()-1);
            } else if (i >= k-1){
                temp.add(score[i]);
                temp.sort(Collections.reverseOrder());
                answer[i]=temp.get(k-1);
            }
        }
        return answer;
    }
}
