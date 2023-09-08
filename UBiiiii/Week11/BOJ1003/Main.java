package BOJ1003;

/*
 * 피보나치 -> 이전 값과 이전전 값을 더하는 방식 -> 0과 1의 호출도 이전 호출과 이전전 호출을 더한 만큼 호출할 것
 * f(n) = f(n-1) + f(n-2)를 0과 1의 호출값에 대해서 동작하게 하자 -> 각 원소를 배열로 선언해서 저장하자
 */

import java.io.*;

public class Main {
    static int zero, one;
    static int[][] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num = 0;

        //피보나치를 0, 1을 호출하는 횟수를 더하는 방식으로 변경
        for(int i=0;i<n;i++) {
            num = Integer.parseInt(br.readLine());
            cnt = new int[41][2];
            cnt[0] = new int[] {1, 0};
            cnt[1] = new int[] {0, 1};
            for(int j=2;j<=num;j++) {
                cnt[j][0] = cnt[j-2][0] + cnt[j-1][0];
                cnt[j][1] = cnt[j-2][1] + cnt[j-1][1];
            }
            sb.append(cnt[num][0]).append(" ").append(cnt[num][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}