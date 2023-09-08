package BOJ1003;

import java.io.*;

public class Main {
    static int zero, one;
    static int[][] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num = 0;
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