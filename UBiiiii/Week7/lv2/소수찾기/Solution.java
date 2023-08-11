package UBiiiii.Week7.lv2.소수찾기;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++)   arr[i] = Integer.toString(numbers[i]);
        Arrays.sort(arr, (a,b)->compare(a,b));
        Arrays.stream(arr).forEach(sb::append);
        return sb.charAt(0)=='0' ? "0" : sb.toString();
    }
    
    private static int compare(String a, String b) {
        return Integer.parseInt(b+a) - Integer.parseInt(a+b);
    }
}