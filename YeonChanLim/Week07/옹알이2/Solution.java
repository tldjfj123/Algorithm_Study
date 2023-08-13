package YeonChanLim.Week07.옹알이2;

import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        // 각 문자에 대응되는 단어들을 저장하는 해시맵을 생성
        HashMap<Character, String> words = new HashMap<Character, String>() {{
            put('a', "aya");
            put('y', "ye");
            put('w', "woo");
            put('m', "ma");
        }};
        int answer = 0;  //변수 초기화

        // 주어진 문자열 배열(babbling)의 각 문자열을 반복 처리
        for (String s : babbling) {
            char prev = ' ';  // 이전 문자를 저장하는 변수를 공백 문자로 초기화
            int i = 0;        // 문자열의 인덱스를 나타내는 변수를 초기화
            boolean isValid = true;  // 현재 문자열이 유효한지를 나타내는 변수를 초기화

            // 현재 문자열을 한 글자씩 처리하는 반복문
            while (i < s.length()) {
                // 이전 문자와 현재 문자가 같다면, 유효하지 않은 문자열
                if (prev == s.charAt(i)) {
                    isValid = false;
                    break;
                }

                // 현재 문자에 해당하는 단어를 해시맵에서 가져옴
                String word = words.getOrDefault(s.charAt(i), "");

                // 단어가 없다면, 유효하지 않은 문자열
                if (word.equals("")) {
                    isValid = false;
                    break;
                }

                // 현재 위치부터 단어의 길이만큼 문자열을 가져옴
                String curStr = s.substring(i, Math.min(s.length(), i + word.length()));

                // 현재 문자열이 단어와 같다면, 이전 문자를 갱신하고 인덱스를 이동
                if (curStr.equals(word)) {
                    prev = s.charAt(i);
                    i += word.length();
                } else {
                    isValid = false;  // 현재 문자열이 단어와 다르다면, 유효하지 않은 문자열
                    break;
                }
            }

            // 문자열이 유효하다면
            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
