/**
 * n	방법
 * 1	1
 * 2	2
 * 3	3
 * 4	5
 * 5	8
 * 6	13
 * -> n = 3부터 현 단계 = 전단계 + 전전단계
 * 주의사항 : 숫자가 커질 수 있어서 1000000007로 나누면서 연산
 */

class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        if (n < 3) {
            return dp[n];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }
}