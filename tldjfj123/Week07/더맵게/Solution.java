package 더맵게;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //priority queue 구현

        for (int s : scoville) { // 배열을 priorityqueue로
            minHeap.add(s);
        }

        int res = 0;
        while (minHeap.size() > 1) { // IndexError 방지 위해 2개 이상일때까지 계산함
            if (minHeap.peek() >= K) {
                return res;
            }

            int first = minHeap.poll();
            int second = minHeap.poll() * 2;

            minHeap.add(first + second);
            res++;
        }

        System.out.println("minHeap = " + minHeap);

        // priority queue 안에 원소가 1개 남았거나 없는 경우
        if (minHeap.peek() >= K) {
            return res;
        } else {
            return -1;
        }

    }
}