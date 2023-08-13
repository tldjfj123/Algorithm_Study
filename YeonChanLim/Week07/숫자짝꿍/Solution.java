package YeonChanLim.Week07.숫자짝꿍;

import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        // 문자열 X와 Y에 각 문자별 빈도를 저장할 맵들을 생성
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        // 문자열 X의 각 문자에 대해 빈도를 계산하여 xMap에 저장
        for(String key: X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0) + 1);
        }

        // 문자열 Y의 각 문자에 대해 빈도를 계산하여 yMap에 저장
        for(String key: Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0) + 1);
        }

        // xMap의 키(문자)들을 순회하면서, yMap에 해당 문자가 있는지 확인하고 처리
        for(String key: xMap.keySet()) {
            if(!yMap.containsKey(key)) continue;  // yMap에 해당 문자가 없으면 다음 문자로 넘어감

            // 문자의 빈도 중 작은 값을 선택하여 리스트에 해당 문자를 추가
            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }

        // 결과 문자열 리스트를 내림차순으로 정렬, 문자열로 변환하여 결과를 생성
        String result = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());

        // 결과가 비어있다면 "-1"을 반환
        if(result.isEmpty()) return "-1";
        // 결과 문자열에 "0"만 있다면 "0"을 반환
        if(result.replaceAll("0", "").isEmpty()) return "0";
        return result;
    }
}
