package UBiiiii.Week7.lv2.더맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
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