package IOIOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int[] dp = new int[m];
        int result = 0;

        for (int i = 1; i < m-1; i++) {
            if (s[i] == 'O' && s[i+1] == 'I') {
                dp[i+1] = dp[i-1] + 1;

                if (dp[i+1] >= n && s[i - 2 * n + 1] == 'I') {
                    result++;
                }

            }
        }

        System.out.println(result);
    }

}