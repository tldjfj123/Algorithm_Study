package YeonChanLim.Week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  //테스트 케이스 개수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());  //층 수
            int w = Integer.parseInt(st.nextToken());  //각 층의 방 수
            int n = Integer.parseInt(st.nextToken());  //n번째 손ㄴ;ㅁ
            if (n % h == 0) {  //나머지가 0이면 가장 높은 층으로 올라감
                sb.append(h);
            } else {
                sb.append(n % h);
            }
            double room = Math.ceil((double)n / (double)h);
            if (room < 10) {
                sb.append("0");
            }
            sb.append((int)room + "\n");
        }
        System.out.print(sb);
    }
}

