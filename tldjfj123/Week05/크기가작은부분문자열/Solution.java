package 크기가작은부분문자열;
import java.math.BigDecimal;

class Solution {
    public int solution(String t, String p) {
        int result = 0;
        for (int i = 0; i < t.length() - p.length()+1; i++) {
            BigDecimal tmp1 = new BigDecimal(t.substring(i, i+p.length()));
            BigDecimal tmp2 = new BigDecimal(p);

            int compareResult = tmp1.compareTo(tmp2);
            if (compareResult <= 0){
                result++;
            }
        }
        return result;
    }
}