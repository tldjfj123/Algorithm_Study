package UBiiiii.Week7.lv1.옹알이_2;

class Solution {
    private static String[] words = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling)  answer += check(str, "aaa") ? 1 : 0;
        return answer;
    }
    
    private static boolean check(String str, String pre) {
        for(String w : words) if(pre!=w&&str.startsWith(w)) return check(str.substring(w.length()), w);
        return str.length()==0 ? true : false;
    }
}