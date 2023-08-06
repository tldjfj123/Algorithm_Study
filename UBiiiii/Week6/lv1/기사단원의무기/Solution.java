package 기사단원의무기;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        //필요한 철의 무게
        int[] fe = new int[number];

        // 약수의 수만큼 무게 필요 -> 각 수의 배수ㄷㅡㄹ에 +1
        for(int i=1; i<=number; i++) {
            int j=i;
            while(j<=number) {
                fe[j-1]++;
                j+=i;
            }
        }

        // limit를 넘어가면 정해진 값으로 바꿔서 더하기
        for(int f : fe) {
            if(f > limit)   answer += power;
            else            answer += f;
        }
        return answer;
    }
}