package UBiiiii.Week8.lv1.신규_아이디_추천;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase().replaceAll("[^a-zA-Z0-9._-]", "").replaceAll("\\.{2,}", ".").replaceAll("^[.]|[.]$", "");
        if(answer.isEmpty())    answer = "a";
        if(answer.length() > 15) answer = answer.substring(0, 15).replaceAll("[.]$", "");
        else if(answer.length() < 3) answer += answer.substring(answer.length()-1).repeat(3-answer.length());
        return answer;
    }
}