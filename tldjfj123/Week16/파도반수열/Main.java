package 파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        //1, 1, 1, 2, 2, 3, 4, 5, 7, 9
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i <= 100; i++) {
            arr[i] = arr[i-3] + arr[i-2];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
    }
}
