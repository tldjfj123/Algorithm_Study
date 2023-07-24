package 추억점수;

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        LinkedHashMap<String, Integer> dict = new LinkedHashMap<String, Integer>();

        for (int i = 0; i < name.length; i++) {
            dict.put(name[i], yearning[i]);
        }

        List<Integer> answer = new ArrayList<Integer>();

        for (String[] p : photo) {
            int res = 0;
            for (String s : p) {
                if(dict.containsKey(s)) {
                    res += dict.get(s);
                }
            }
            answer.add(res);
        }

        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }
}