package UBiiiii.Week8.lv1.신규_아이디_추천;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase()                                             //1단계
                       .replaceAll("[^a-zA-Z0-9._-]", "")       //2단계
                       .replaceAll("\\.{2,}", ".")              //3단계
                       .replaceAll("^[.]|[.]$", "");            //4단계
        if(answer.isEmpty())    answer = "a";                                     //5단계
        if(answer.length() > 15)                                                  //6단계
            answer = answer.substring(0, 15)
                           .replaceAll("[.]$", "");
        if(answer.length() < 3)                                                   //7단계
            answer += answer.substring(answer.length()-1)
                            .repeat(3-answer.length());
        return answer;
    }
}