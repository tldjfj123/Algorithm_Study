package UBiiiii.Week9.lv1.키패드누르기;

import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static int ld = 0, rd = 0;
    static int[] left = {3, 0}, right = {3, 2}, pos = {};
    
    public String solution(int[] numbers, String hand) {
        Map<Integer, int[]> keypad = new HashMap<>();
        keypad.put(0, new int[] {3, 1});
        keypad.put(1, new int[] {0, 0});
        keypad.put(2, new int[] {0, 1});
        keypad.put(3, new int[] {0, 2});
        keypad.put(4, new int[] {1, 0});
        keypad.put(5, new int[] {1, 1});
        keypad.put(6, new int[] {1, 2});
        keypad.put(7, new int[] {2, 0});
        keypad.put(8, new int[] {2, 1});
        keypad.put(9, new int[] {2, 2});
        
        for(int n : numbers) {
            pos = keypad.get(n);
            switch(pos[1]) {
                case 0:
                    changePos('L', pos);
                    break;
                case 2:
                    changePos('R', pos);
                    break;
                default:
                    ld = Math.abs(left[0]-pos[0]) + Math.abs(left[1]-pos[1]);
                    rd = Math.abs(right[0]-pos[0]) + Math.abs(right[1]-pos[1]);
                    if(rd > ld) changePos('L', pos);
                    else if(rd < ld)    changePos('R', pos);
                    else changePos(hand.charAt(0)=='r' ? 'R' : 'L', pos);
            }
        }
        return sb.toString();
    }
    
    private static void changePos(char hand, int[] pos) {
        sb.append(hand);
        if(hand=='L')   left = pos;
        else            right = pos;
    }
}