package 기사단원의무기;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] fe = new int[number];
        for(int i=1; i<=number; i++) {
            int j=i;
            while(j<=number) {
                fe[j-1]++;
                j+=i;
            }
        }
        for(int f : fe) {
            if(f > limit)   answer += power;
            else            answer += f;
        }
        return answer;
    }
}