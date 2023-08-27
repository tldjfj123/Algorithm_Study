package UBiiiii.Week9.lv1.크레인인형뽑기;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0, tmp = 0;
        Stack<Integer> store = new Stack<>();
        Stack<Integer>[] map = new Stack[board.length];
        for(int i=0;i<map.length;i++)   map[i] = new Stack<>();
        for(int i=map.length-1;i>-1;i--) {
            for(int j=0;j<map.length;j++)   if(board[i][j]!=0)  map[j].push(board[i][j]);
        }
        
        for(int m : moves) {
            if(map[m-1].isEmpty())  continue;
            
            tmp = map[m-1].pop();
            if(store.isEmpty() || store.peek()!=tmp) store.push(tmp);
            else  {
                store.pop();
                answer+=2;
            }
        }
        return answer;
    }
}