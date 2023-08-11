package UBiiiii.Week7.lv2.가장큰수;

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
    
    /*
     * 두 문자열을 비교하는 데에 사용되는 함수
     * 주어진 numbers를 커지는 순으로 정렬하기 위하여 사용
     */
    private static int compare(String a, String b) {
        return Integer.parseInt(b+a) - Integer.parseInt(a+b);
    }
}