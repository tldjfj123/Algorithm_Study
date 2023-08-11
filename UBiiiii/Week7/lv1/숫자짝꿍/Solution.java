package UBiiiii.Week7.lv1.숫자짝꿍;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] xcnt = new int[10];
        int[] ycnt = new int[10];
        for(int i=0;i<X.length();i++)   xcnt[X.charAt(i)-'0']++;
        for(int i=0;i<Y.length();i++)   ycnt[Y.charAt(i)-'0']++;
        for(int i=9;i>=0;i--)   sb.append(Integer.toString(i).repeat(Math.min(xcnt[i], ycnt[i])));
        
        return sb.length()==0 ? "-1" : (sb.charAt(0)=='0' ? "0" : sb.toString());
    }

}