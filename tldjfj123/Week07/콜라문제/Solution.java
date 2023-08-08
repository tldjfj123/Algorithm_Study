package 콜라문제;

class Solution {
    // 써 있는대로 하면 됨.
    public int solution(int a, int b, int n) {
        int res = 0;
        while (n >= a) {
            res += (n / a) * b;
            n = n - ((n / a) * a) + ((n / a) * b);
        }
        return res;
    }
}