package 가장가까운같은글자;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            answer[i] = idx[c-'a']<0 ? -1 : i-idx[c-'a'];
            idx[c-'a'] = i;
        }
        return answer;
    }
}