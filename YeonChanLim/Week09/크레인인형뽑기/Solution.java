package YeonChanLim.Week09.크레인인형뽑기;

/*
바구니를 채우면서 인형이 제거 되는거니까 stack을 사용해야겄다는 생각
stack 연산
- pop(): 스택에서 가장 위에 있는 항목을 제거
- push(item): item 하나를 스택의 가장 윗 부분에 추가
- peek(): 스택의 가장 위에 있는 항목을 반환
- isEmpty(): 스택이 비어 있을 때에 true를 반환
stack 참고 사이트 : https://gmlwjd9405.github.io/2018/08/03/data-structure-stack.html

 */

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        // moves = 크레인의 총 이동 횟수
        for(int i = 0; i < moves.length; i++){
            // j 보드 행 탐색 열 moves 원소로 탐색
            for(int j = 0; j < board.length; j++){
                // 인형 존재할때
                if(board[j][moves[i] - 1] != 0){
                    // stack이 빈 값이 아니고 스택 최상단이랑 크레인으로 뽑은 인형이 같을때
                    if(!stack.empty() && stack.peek() == board[j][moves[i] - 1]){
                        // 인형 제거 ++, 바구니 인형 제거, 크레인으로 뽑은 인형 0으로
                        answer++;
                        stack.pop();
                        board[j][moves[i] - 1] = 0;
                        break;
                        //그 외의 경우는 바구니로 담고 0
                    } else {
                        stack.push(board[j][moves[i] - 1]);
                        board[j][moves[i] - 1] = 0;
                        break;
                    }
                }
            }
        }
        return answer * 2;
    }
}

/*
public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.peek() == board[j][move - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move - 1]);
                    }
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }*/
