package 문자열나누기;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String start = "a";
        int[] cnt = new int[] {0, 0};
        for(String c : s.split("")) {
            if(cnt[0] == cnt[1]) {
                answer++;
                start = c;
                cnt = new int[] {1, 0};
            } else {
                if(start.equals(c)) cnt[0]++;
                else                cnt[1]++;
            }
        }
        return answer;
    }
}