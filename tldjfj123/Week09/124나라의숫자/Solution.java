import java.util.ArrayList;
import java.util.List;

/**
 *
 * 124 나라
 * 1	1
 * 2	2
 * 3	4
 * 4	11
 * 5	12
 * 6	14
 * 7	21
 * 8	22
 * 9	24
 * 10	41
 * 11	42
 * 12	44
 * 13	111
 * 14	112
 * 15	114
 * 16	121
 * 17	122
 * 18	124
 * 19	141
 * 20	142
 * 21	144
 * 22	211
 * 23	212
 * 24	214
 * 25	221
 * 26	222
 * 27	224
 * 28	241
 * 29	242
 * 30	244
 *
 *
 * 1. 나눠떨어질 경우 :  0이 아니라 4임 & 몫-1 해줘야함
 * 2. 아닐결우 : 그냥 연산

 */

class Solution {
    //효율적 연산위해 StringBuilder 사용
    StringBuilder sb = new StringBuilder();
    public String solution(int n) {
        while (n > 0) {
            if (n % 3 == 0) {
                sb.insert(0, "4");
                n = (n / 3) - 1;
            }
             else {
                 sb.insert(0, String.valueOf(n % 3));
                 n /= 3;
            }
        }

        return sb.toString();
    }
}