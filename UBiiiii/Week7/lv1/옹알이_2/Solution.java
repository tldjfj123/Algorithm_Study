package UBiiiii.Week7.lv1.옹알이_2;

class Solution {
    private static String[] words = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling)  answer += check(str, "aaa") ? 1 : 0;
        return answer;
    }
    
    /*
     * 문자열 체크 함수
     * 문자열의 시작이 옹알이 문자에 포함되면 해당 문자열 이후에 대해서 check
     * 동일한 단어를 중복해서 말할 수 없다 -> 이전에 사용한 문자열 pre를 이용하여 중복 예방
     */
    private static boolean check(String str, String pre) {
        for(String w : words) if(pre!=w&&str.startsWith(w)) return check(str.substring(w.length()), w);
        return str.length()==0 ? true : false;
    }
}