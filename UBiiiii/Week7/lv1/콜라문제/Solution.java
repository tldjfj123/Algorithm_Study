package UBiiiii.Week7.lv1.콜라문제;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a) {
            int num = n/a;
            answer += num*b;
            n -= num*(a-b);
        }
        return answer;
    }
}