package 전화번호목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int shortest = -1;
        Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());
        shortest = phone_book[0].length();
        for(String phone : phone_book) {
            for(int i=1;i<phone.length();i++) {
                if(map.containsKey(phone.substring(0, i)))  {
                    answer = false;
                    break;
                }
            }
            map.put(phone, false);
        }
        return answer;
    }
}