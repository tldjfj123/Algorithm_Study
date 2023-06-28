package YeonChanLim.Week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10951 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받을 값을 담을 변수
        
        String s;
        // 입력이 있으면 while문을 수행하고 없다면 종료
        while ((s = br.readLine()) != null){
            // 입력 값을 split하여 계산
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);

            // 출력
            bw.write((a+b) + "\n");
        }
        bw.flush();
    }
}