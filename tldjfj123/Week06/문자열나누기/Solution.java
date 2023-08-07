package 문자열나누기;

import java.util.*;

class Solution {
    public int solution(String s) {
        //Convert String to Deque with ArrayDeque for get deque's index
        Deque<Character> arr = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            arr.offer(c);
        }

        int result = 0;

        //std = first idx value of ArrayDeque
        //Compare the first index value with the remaining values and count at sameCnt & diffCnt
        while (!arr.isEmpty()) {
            char std = arr.peekFirst();
            int sameCnt = 0;
            int diffCnt = 0;

            for (char c : arr) {
                if (std == c) {
                    sameCnt++;
                } else {
                    diffCnt++;
                }
                //If sameCnt == diffCnt -> Remove the corresponding values from the deque.
                if (sameCnt == diffCnt) {
                    result++;
                    for (int i = 0; i < sameCnt + diffCnt; i++) {
                        arr.pollFirst();
                    }
                    break;
                }
            }
            // Handle exceptions -> case "abracadabra"
            if (sameCnt != diffCnt) {
                result++;
                break;
            }
        }

        return result;
    }

}