package 둘만의암호;

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<String> alpha = new ArrayList<>();
        String[] sa = skip.split("");
        for(String c : "abcdefghijklmnopqrstuvwxyz".split("")) {
            if(Arrays.asList(sa).contains(c))    continue;
            alpha.add(c);
        }
        for(String c : s.split("")) {
            int idx = alpha.indexOf(c);
            answer += alpha.get((idx+index)%alpha.size());
        }
        return answer;
    }
}