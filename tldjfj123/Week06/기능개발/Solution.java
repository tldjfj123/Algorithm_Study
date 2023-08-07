package 기능개발;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Deque<Integer> progressesQueue = new LinkedList<>();
        Deque<Integer> speedsQueue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        //직관적인 풀이를 위해 progress와 speed 모두 Deque로 변환
        for (int progress : progresses) {
            progressesQueue.add(progress);
        }
        for (int speed : speeds) {
            speedsQueue.add(speed);
        }

        while (!progressesQueue.isEmpty()) {
            // 작업 진행 상태와 작업 속도를 합친 후 다시 Deque에 집어넣음
            for (int i = 0; i < speedsQueue.size(); i++) {
                int progress = progressesQueue.poll();
                int speed = speedsQueue.poll();
                progress += speed;
                progressesQueue.add(progress);
                speedsQueue.add(speed);
            }

            //
            int cnt = 0;
            while (!progressesQueue.isEmpty()) {
                // 작업 완료(100 이상) 시, Deque에서 제거하며 한번에 제거 된 작업의 수를 결과 배열에 추가
                if (progressesQueue.peek() >= 100) {
                    progressesQueue.poll();
                    speedsQueue.poll();
                    cnt++;
                } else {
                    break;
                }
            }

            if (cnt != 0) {
                result.add(cnt);
            }
        }
        return result;
    }
}