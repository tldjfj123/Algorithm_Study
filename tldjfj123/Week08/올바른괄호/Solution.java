package 올바른괄호;

import java.util.*;

/**
 * stack이 비었다!!
 * -> 무조건 push
 *
 * stack이 들어있다!
 * 1. value == (
 * -> 걍 push
 * 2. value == )
 * 1. peek가 ) : 그냥 push
 * 2. peek가 ( : 그냥 pop
 */

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);

            if (stack.isEmpty()) {
                stack.add(value);
            } else {
                if (value == '(') {
                    stack.add(value);
                } else {
                    if (stack.peek() == ')') {
                        stack.add(value);
                    } else {
                        stack.pop();
                    }
                }
            }

        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}