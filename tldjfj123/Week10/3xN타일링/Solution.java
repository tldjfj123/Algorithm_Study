/**
 * 2 3
 * 4 11
 * 6 41
 *
 * --> f(n) = f(n-2) * 4 - f(n-4)
 *  f(n-4)가 * f(n-2) * 4 보다 커질 수도 있으므로 모듈러 분배법칙 사용
 *  (A - B) % p = ((A % p) - (B % p) + p) % p
 */

class Solution {
    long[] tile = new long[5001];

    public long solution(int n) {
        long answer = 0;
        int mod=1000000007;
        // 규칙활용 f(n) = f(n-2)*4 - f(n-4)
        tile[0]=1;
        tile[2]=3;

        //f(n) = ((f(n - 2) x 4 % 1,000,000,007)
        //- (f(n - 4) % 1,000,000,007) + 1,000,000,007) % 1,000,000,007
        for(int i=4; i<=n; i+=2){
            tile[i]= (tile[i-2]*4%mod -tile[i-4]%mod +mod)%mod;

        };

        return answer=tile[n];
    }


}