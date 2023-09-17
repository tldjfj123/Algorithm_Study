package YeonChanLim.Week12.잃어버린괄호;

/*
사칙연산이 다 있었으면 빡셌을거 같은데 쁠마만 있어서 다행 ㅋㅋ
1+2+3-4+5+6 일때 합이 최소가 되려면 - 뒤 부분 먼저 더하고 뺄셈하면 됨
따라서 (1+2+3)-(4+5+6) 이렇게 계산해야되니까
"-" 토큰을 기준으로 분리 ->  1+2+3 과 4+5+6
"+" 토큰을 기준으로 분리 시킨 후 더해줌.
더해준 값들을 빼기.
여기서 주의할 점은 맨 처음 묶음 즉, 1+2+3 은 빼주는 것이 아닌 더해줘야됨.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cal = br.readLine().split("-"); // 빼기를 기준으로 분리
        int res = 0;
        for(int i=0;i<cal.length;i++) {
            int sum = 0;
            String[] cal2 = cal[i].split("\\+");
            for(int j=0;j<cal2.length;j++) {
                sum += Integer.parseInt(cal2[j]);
            }
            if(i==0) {
                res += sum;
            }else {
                res -= sum;
            }
        }
        System.out.println(res);
    }
}
