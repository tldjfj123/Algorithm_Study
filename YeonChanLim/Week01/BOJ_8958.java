package YeonChanLim.Week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int add = 0;
            int score = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    add++;
                    score += add;
                } else {
                    add = 0;
                }
            }
            sb.append(score + "\n");
        }
        System.out.print(sb);
    }
}
