package UBiiiii.Week8.lv2.H_index;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = -1;
        Arrays.sort(citations);
        while(++n < citations.length && citations[n] < citations.length - n);
        return citations.length - n;
    }
}
