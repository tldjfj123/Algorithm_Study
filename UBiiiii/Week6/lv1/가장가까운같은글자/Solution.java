package 가장가까운같은글자;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        //1. 리스트를 이용한 방식
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            answer[i] = idx[c-'a']<0 ? -1 : i-idx[c-'a'];
            idx[c-'a'] = i;
        }

        return answer;

        //2. Map을 이용한 방식
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i=0;i<s.length();i++) {
        //     char c = s.charAt(i);
        //     answer[i] = map.containsKey(c) ? map.get(c) : -1;
        //     map.put(c, i);
        // }
        // return answer;
    }
}