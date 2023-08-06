package 문자열나누기;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char start = 'a';
        int[] cnt = new int[] {0, 0};           // 문자열의 첫 글자와 같은 글자, 다른 글자의 수를 세는 배열

        /* 
         * 같은 글자와 다른 글자의 수가 같아지면 새로운 문자열을 시작하고 answer++
         * 그 전까지 문자마다 비교하여 배열에 수 변환
        */
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(cnt[0] == cnt[1]) {
                answer++;
                start = c;
                cnt = new int[] {1, 0};
            } else {
                if(start == c) cnt[0]++;
                else                cnt[1]++;
            }
        }
        return answer;
    }
}