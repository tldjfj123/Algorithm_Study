package YeonChanLim.Week08.올바른괄호;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true; // 결과 값 초기화
        Stack<Character> stack = new Stack<>(); // 괄호를 처리하기 위한 스택

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); // 문자열에서 현재 문자 추출

            if(c == '('){
                stack.push(c); // 열린 괄호일 경우 스택에 추가
            }

            if(c == ')'){
                if(stack.size() == 0){ // 스택이 비어있는데 닫힌 괄호가 나오면 균형이 맞지 않음
                    return false;
                }
                else stack.pop(); // 스택에서 가장 최근에 추가된 열린 괄호 제거 (균형이 맞는 경우)
            }
        }
        if(stack.size() != 0) answer = false; // 모든 문자 처리 후에도 스택에 열린 괄호가 남아있으면 균형이 맞지 않음

        return answer;
    }
}
