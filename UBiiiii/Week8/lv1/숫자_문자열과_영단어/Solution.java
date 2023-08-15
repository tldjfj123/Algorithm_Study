package UBiiiii.Week8.lv1.숫자_문자열과_영단어;

class Solution {
    static String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        String answer = s;
        for(int i=0;i<10;i++)   answer = answer.replaceAll(number[i], Integer.toString(i));
        return Integer.parseInt(answer);
    }
}