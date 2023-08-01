package 햄버거만들기;

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i : ingredient) {
            sb.append(i);
            if(sb.length()>=4 && sb.substring(sb.length()-4).equals("1231")) {
                answer++;
                sb.delete(sb.length()-4, sb.length());
            }
        }
        
        return answer;
    }
}