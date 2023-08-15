package UBiiiii.Week8.lv2.의상;

import java.util.Map;
import java.util.HashMap;

class Solution {
    /*
     * Map을 이용하여 종류별로 개수 확인
     * "입지 않는다"를 포함하여 옷을 갈아입는 전체 경우의 수 - 1(아무것도 입지 않는 경우)
     */
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }
        for(String key : map.keySet())  answer*=map.get(key)+1;
        return answer-1;
    }
}