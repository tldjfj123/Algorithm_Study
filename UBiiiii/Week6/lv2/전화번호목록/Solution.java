package 전화번호목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        //map: 접두어가 없는 문자열을 저장하는 용도
        Map<String, Boolean> map = new HashMap<>();
        
        /*
            번호를 길이 순으로 정렬
            각 번호를 앞에서부터 동일한 접두어가 있는지 map에서 탐색
            번호가 문제가 없을 경우 map에 추가
        */
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());
        for(String phone : phone_book) {
            for(int i=1;i<phone.length();i++) {
                if(map.containsKey(phone.substring(0, i)))  {
                    return false;
                }
            }
            map.put(phone, false);
        }
        return true;
    }
}