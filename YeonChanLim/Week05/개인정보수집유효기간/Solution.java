package YeonChanLim.Week05.개인정보수집유효기간;

import java.util.*;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        // 유효기간을 담을 map
        Map<String, Integer> map = new HashMap<>();
        // 파기해야할 정보를 담을 list
        List<Integer> list = new ArrayList<>();

        // terms을 순회하며 map에 삽입
        for(String s : terms) {
            String[] temp = s.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }

        // privacies를 순회하며 cal()메서드 호출
        for(int i = 0; i < privacies.length; i++) {
            String[] pSplit = privacies[i].split(" ");
            int valid = map.get(pSplit[1]);
            if(cal(pSplit[0], valid, today)) {
                list.add(i + 1);
            }
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    // 날짜 계산 메서드
    public boolean cal(String date, int valid, String today) {
        int[] dateSplit = Arrays.stream(date.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] todaySplit = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();

        // valid가 1이 될떄까지 유효날짜 계산
        while(valid > 1) {
            dateSplit[2]++;
            valid--;

            if(dateSplit[2] > 28) {
                dateSplit[2] = 1;
                dateSplit[1]++;
            }

            if(dateSplit[1] > 12) {
                dateSplit[1] = 1;
                dateSplit[0]++;
            }
        }

        // 계산한 유효날짜와 현재 날짜를 일수로 바꿔 비교
        int todayResult = todaySplit[0] * 12 * 28 + todaySplit[1] * 28 + todaySplit[2];
        int dateResult = dateSplit[0] * 12 * 28 + dateSplit[1] * 28 + dateSplit[2];

        // 계산한 유효날짜가 현재 날짜보다 크거나 같으면 false 리턴
        if(dateResult >= todayResult) {
            return false;
        }

        return true;
    }
}
