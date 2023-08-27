package 실패율;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> values = new HashMap<>(); // index로 정렬하기 위해 map 사용

        int total = stages.length;
        for (int i = 1 ; i <= N; i++) { //stage 갯수 기준
            int tmp = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    tmp++;
                }
            }
            if (total == 0) { // 아무도 깬 사람이 없는 경우 0으로 추가
                values.put(i, 0.0);
            } else{ //깬 사람이 있는 경우
                values.put(i, (tmp / (double) total));
            }
            total -= tmp;
        }




        List<Integer> result = new ArrayList<>(values.keySet());
        Collections.sort(result, (o1, o2) -> Double.compare(values.get(o2), values.get(o1))); //map의 value값끼리 비교하기 위해 lambda식 및 compare 함수 사

        int[] fin = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            fin[i] = result.get(i);
        }

        return fin;
    }
}