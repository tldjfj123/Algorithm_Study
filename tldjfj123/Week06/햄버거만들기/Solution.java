package 햄버거만들기;

import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < ingredient.length; i++) {
            stack.add(ingredient[i]);
            if (stack.size() >= 4) {
                // Check availability of making hamburger
                int first = stack.elementAt(stack.size()-1);
                int second = stack.elementAt(stack.size()-2);
                int third = stack.elementAt(stack.size()-3);
                int fourth = stack.elementAt(stack.size()-4);

                if (first == 1 && second == 3 && third == 2 && fourth == 1) {
                    result++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }

        }

        return result;
    }
}