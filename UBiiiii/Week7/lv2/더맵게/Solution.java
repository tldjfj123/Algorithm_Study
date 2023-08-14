package UBiiiii.Week7.lv2.더맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        /*
         * 우선순위 큐를 이용하여 제일 맵기가 낮은 두 수를 합쳐 다시 삽입
         * 우선순위 큐의 원소의 수가 1개일 경우 더이상 맵게 할 수 없으므로 -1
         */
        int answer = 0;
        PriorityQueue<Long>queue = new PriorityQueue<>();
        for(int i : scoville) queue.offer(Long.valueOf(i));
        while(queue.peek()<K) {
            if(queue.size()==1) return -1;
            queue.offer(queue.poll() + queue.poll()*2);
            answer++;
        }
        return answer;
    }
}