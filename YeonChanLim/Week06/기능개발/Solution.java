package YeonChanLim.Week06.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>(); // 작업이 완료되는 날짜를 저장할 리스트 생성
        int[] works = new int[progresses.length]; // 각 작업이 완료되기까지 필요한 일수를 저장할 배열 생성

        // 각 작업이 완료되기까지 필요한 일수를 계산하여 'works' 배열에 저장
        for (int i = 0; i < speeds.length; i++) {
            works[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                works[i] += 1;
            }
        }

        int x = works[0]; // x에 첫 번째 작업이 완료되는 일수를 저장
        int count = 1; // count에 같은 날에 완료되는 작업의 개수를 세기 위한 변수를 초기화

        // 동일한 날에 완료되는 작업들을 묶어서 그룹화
        for (int i = 1; i < progresses.length; i++) {
            if (x >= works[i]) { // 이전 작업보다 더 오래 걸리는 경우 작업을 동일한 그룹으로
                count += 1;
            } else { // 이전 작업과 다른 날에 완료되는 경우 이전 그룹의 작업 개수를 리스트에 추가
                list.add(count);
                count = 1; // 새로운 그룹을 시작하므로 count를 1로 초기화
                x = works[i]; // 새로운 그룹의 날짜를 x에 저장
            }
        }
        list.add(count); // 마지막 그룹의 작업 개수를 list에 추가

        int[] answer = new int[list.size()]; // 결과를 저장할 배열 answer 생성

        // list 값을 answer 배열에 복사
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer; // answer 반환
    }
}
