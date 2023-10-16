package ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1 2 3 4 5
 * 1
 * 1 2 -> 3
 * 1 2 3 -> 6
 * 1 2 3 3 -> 9
 * 1 2 3 3 4 -> 13

 */

public class Main11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n; i ++) {
            int tmp = 0;
            for (int j = 0; j < i + 1; j++) {
                tmp += arr[j];
            }
            res += tmp;
        }

        System.out.println(res);


    }
}
