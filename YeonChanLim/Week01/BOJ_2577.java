package YeonChanLim.Week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2577 {
    static int A,B,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        int value = A*B*C;
        String str = Integer.toString(value);
        int count = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)-'0'==i) count++;
            }
            System.out.println(count);
            count=0;
        }
    }
}
