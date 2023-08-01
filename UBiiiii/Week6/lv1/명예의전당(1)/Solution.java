package 명예의전당(1);

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> que = new PriorityQueue<>();
        for(int i=0;i<score.length;i++) {
            int s = score[i];
            que.offer(s);
            if(que.size() > k)  que.poll();
            answer[i] = que.peek();
        }
        return answer;
    }
}