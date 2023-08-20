package 숫자문자열과영단어;

import java.util.*;

/**
 * 1. isDigit() 메소드를 사용하기 위해 String -> char[]
 * 2. char[]를 돌면서 stack에 대입
 * 2-1 : 해당 단어가 영어일경우 -> stack에 계속 대입
 * 2-2 : 해당 단어가 숫자일경우
 * 2-2-1 : stack이 비어있다 -> result에 add
 * 2-2-2 : stack에 뭐가 있다 -> stack의 영어 숫자를 숫자로 바꿔서 result에 대입한 후, stack을 비워냄
 */


class Solution {
    public int solution(String s) {
        //영단어 to 숫자로 바꾸기 위한 HashMap 생성
        HashMap<String, String> map = new HashMap<>();

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        char[] arr = s.toCharArray();
        List<String> result = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();

        for (char a : arr) {
            if (Character.isDigit(a)) {
                result.add(String.valueOf(a));
            } else {
                String v = String.valueOf(a);
                tmp.add(v);
                String check = String.join("", tmp);

                if (map.containsKey(check)) {
                    result.add(map.get(check));
                    tmp.clear();
                }
            }
        }

        return Integer.parseInt(String.join("", result));

    }
}