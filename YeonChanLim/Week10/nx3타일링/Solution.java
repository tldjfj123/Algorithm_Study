package YeonChanLim.Week10.nx3타일링;

/*
이거 노가다 하면서 규칙 찾을라고 노가다 하다가
중도 포기하고 구글링했슴다....
참고 사이트 : https://gom20.tistory.com/180

N이 홀수일 때: dp[N] = dp[N-1]*2 + dp[N-2];

N이 짝수일 때: dp[N] = dp[N-1] + dp[N-2];
 */

class Solution {
    public int solution(int n) {
        int answer = 0;
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[1] = 2;
        dp[2] = 3;
        for(int i = 3; i <= n; i++){
            if(i%2 == 0){
                //짝수
                dp[i] = dp[i-1]%mod + dp[i-2]%mod;
            } else {
                // 홀수
                dp[i] = dp[i-1]*2%mod + dp[i-2]%mod;
            }
            dp[i] = dp[i]%mod;
        }
        return dp[n];
    }
}
