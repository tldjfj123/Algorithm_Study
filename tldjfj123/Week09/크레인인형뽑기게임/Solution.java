package 크레인인형뽑기게임;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        //2차원 배열 세로기준으로 다시 만들기 (뽑기 위해 Stack으로 선언)
        List<Stack<Integer>> pan = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            Stack<Integer> tmp = new Stack<>();
            for (int j = board.length - 1; j > -1; j--) {
                if (board[j][i] != 0) {
                    tmp.add(board[j][i]);
                }
            }

            pan.add(tmp);
        }

        Stack<Integer> result = new Stack<>();
        int answer = 0;

        // 명령에 맞춰서 움직임
        for (int i = 0; i < moves.length; i++) {
            int order = moves[i] - 1;
            Stack<Integer> target = pan.get(order);

            if (!target.isEmpty()) {
                int value = target.pop();
                if (result.isEmpty()) {
                    result.add(value);
                } else {
                    if (result.peek() == value) {
                        result.pop();
                        answer++;
                    }
                    else {
                        result.add(value);
                    }
                }
            }
        }


        return answer * 2; // 없어진 갯수는 * 2
    }
}