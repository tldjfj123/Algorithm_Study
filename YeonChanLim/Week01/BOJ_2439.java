package YeonChanLim.Week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2439 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=N- i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
