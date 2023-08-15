package 숫자짝꿍;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String solution(String X, String Y) {
        HashMap<String, Integer> mapX = new HashMap<>();
        HashMap<String, Integer> mapY = new HashMap<>();

        //About X
        for (int i = 0; i < X.length(); i++) {
            String key = String.valueOf(X.charAt(i));
            if (!mapX.containsKey(key)) {
                mapX.put(key, 1);
            } else {
                Integer tmp = mapX.get(key);
                mapX.put(key, tmp + 1);
            }
        }

        //About Y
        for (int i = 0; i < Y.length(); i++) {
            String key = String.valueOf(Y.charAt(i));
            if (!mapY.containsKey(key)) {
                mapY.put(key, 1);
            } else {
                Integer tmp = mapY.get(key);
                mapY.put(key, tmp + 1);
            }
        }

        ArrayList<String> arr = new ArrayList<>();

        // 정렬 필요없게 9부터 탐색
        for (int i = 9; i > -1; i--) {
            String key = String.valueOf(i);
            if (mapY.get(key) != null && mapX.get(key) != null) {
                int tmp = Math.min(mapY.get(key), mapX.get(key));
                for (int j = 0; j < tmp; j++) {
                    arr.add(String.valueOf(i));
                }
            }
        }

        if (arr.isEmpty()) {
            return "-1";
        } else if (arr.stream().allMatch(element -> element.equals("0"))) { //"00" 같은 케이스 제거
            return "0";
        } else {
            return String.join("", arr);
        }

    }
}