package 기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> task = new LinkedList<>();
        int sp = 0, cnt = 0;    // sp: 문자열 위치를 가리킬 포인터, cnt: 같은 날 배포된 기능 카운트
        while(sp<progresses.length) {
            cnt = 0;
            // 하루동안 진행상황 업데이트(이미 처리된 기능은 X)
            for(int i=sp;i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            // 오늘 진행률이 100이 넘은 기능 카운트
            while(sp<progresses.length && progresses[sp] >= 100) {
                cnt++;
                sp++;
            }
            if(cnt>0)   task.offer(cnt);
        }

        // Queue에 삽입한 걸 앞에서부터 꺼내서 문자열 만들기
        answer = new int[task.size()];
        for(int i=0;i<answer.length; i++) {
            answer[i] = task.poll();
        }

        return answer;
    }
}