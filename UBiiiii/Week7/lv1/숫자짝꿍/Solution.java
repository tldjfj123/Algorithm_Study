package UBiiiii.Week7.lv1.숫자짝꿍;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        //각 숫자마다 들어있는 수를 계산하기 위한 카운터
        int[] xcnt = new int[10];
        int[] ycnt = new int[10];

        /*
         * 두 수 X, Y의 각 자리 수를 이용하여 개수 측정
         * 큰 수부터 두 수 중 적게 들어있는 양 만큼 반복하여 추가
         */
        for(int i=0;i<X.length();i++)   xcnt[X.charAt(i)-'0']++;
        for(int i=0;i<Y.length();i++)   ycnt[Y.charAt(i)-'0']++;
        for(int i=9;i>=0;i--)   sb.append(Integer.toString(i).repeat(Math.min(xcnt[i], ycnt[i])));
        
        return sb.length()==0 ? "-1" : (sb.charAt(0)=='0' ? "0" : sb.toString());
    }

}