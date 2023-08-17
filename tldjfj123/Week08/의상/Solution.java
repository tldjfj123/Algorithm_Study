package 의상;

import java.util.HashMap;
import java.util.Set;
/**
 * !핵심! : 1가지는 무조건 입어야함
 *
 * 1. 옷 유형이 1개 밖에 없다!!
 * -> 걍 그 유형 값 만큼이 답
 *
 * 2. 옷 유형이 2개 이상이다!!
 * -> 해당 유형을 입을지 안입을지 취사 선택이 가능하므로 급식떄 배운 경우의 수 활용
 * -> 각각의 (경우의수 + 안입는 경우 1가지) 를 계속 곱해주고, 전부 다 안입는 경우가 1번 중복되므로 -1 해줌
 *
 */

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            String type = c[1];
            String name = c[0];

            if (!map.containsKey(type)) {
                map.put(type, 1);
            } else {
                int tmp = map.get(type);
                map.put(type, tmp + 1);
            }
        }

        int res = 1;

        Set<String> keySet = map.keySet();

        if (keySet.size() == 1) {
            for (String s : keySet) {
                res *= map.get(s);
                return res;
            }
        } else {
            for (String s : keySet) {
                res *= map.get(s) + 1;
            }
        }

        return res-1;
    }
}