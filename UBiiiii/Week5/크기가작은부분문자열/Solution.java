package 크기가작은부분문자열;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        for(int i=0;i<t.length() - p.length() +1; i++) {
            String sub = t.substring(i, i+p.length());
            if(Long.parseLong(sub) <= Long.parseLong(p)) answer++;
        }
        
        return answer;
    }
}