package YeonChanLim.Week05.크기가작은부분문자열;

public class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int plength = p.length();
        for(int i = 0; i < t.length(); i++){
            int endIdx = i + plength;

            if(endIdx > t.length()){
                break;
            }
            else{
                if(Long.valueOf(t.substring(i, endIdx)) <= Long.valueOf(p)){
                    answer++;
                }
            }
        }
        return answer;
    }
}
