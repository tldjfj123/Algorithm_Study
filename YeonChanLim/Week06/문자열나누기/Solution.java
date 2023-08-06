package YeonChanLim.Week06.문자열나누기;

class Solution {
    public int solution(String s) {
        int answer = 0;

        //첫번째 문자 추출
        char f = s.charAt(0);

        //idx - 처음나온 문자의 갯수, jdx - 처음나온 문자가 아닌 문자의 갯수
        int idx = 0, jdx = 0;

        for (int i = 0; i < s.length(); i++) {
            //처음나온 문자의 갯수와 처음나온 문자가 아닌 문자의 갯수가 같을때 문자열 분리를 위해 answer를 증가하고 첫번째 문자 지정
            if (idx == jdx) {
                answer++;
                f = s.charAt(i);
            }
            //추출한 첫번째 문자와 동일할때 idx증가시키고 아니면 jdx증가
            if (s.charAt(i) == f) idx++;
            else jdx++;
        }

        return answer;
    }
}
