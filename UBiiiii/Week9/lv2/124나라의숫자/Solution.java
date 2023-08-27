package UBiiiii.Week9.lv2.124나라의숫자;

import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int num = n/3;
            switch(n - num*3) {
                case 0:
                    num -= 1;
                    sb.append(4);
                    break;
                default:
                    sb.append(n-num*3);
            }
            n = num;
        }

        return sb.reverse().toString();
    }
}