package YeonChanLim.Week07.콜라문제;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(true){
            if(n < a){
                break;
            }
            answer += (n/a) * b;
            int s = n % a;
            n = (n/a) * b + s;
        }
        return answer;
    }
}
