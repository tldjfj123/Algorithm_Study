package BOJ2579;

/*
 * 계단 오르기
 * 올라갈 수 있는 모든 케이스를 만들어보자
 * 각 계단마다 올라오는 데에 쌓이는 점수 저장. 배열의 0번 인덱스에는 다음 계단을 올라갈 수 있는 값을, 1번 인덱스에는 다음 계단을 올라갈 수 없는 값을 저장.
 * 계단이 1개, 2개 있을 때 충돌이 있을 수 있으므로 해당 케이스는 탈출할 수 있게 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stairs, tmp;
        int[][] cnt;
        int n = Integer.parseInt(br.readLine());
        stairs = new int[n];
        cnt = new int[n][2];
        for(int i=0;i<n;i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if(n==1) {
            System.out.println(stairs[0]);
            return;
        }

        cnt[0][0] = stairs[0];
        cnt[1][0] = stairs[1];
        cnt[1][1] = stairs[1]+stairs[0];

        if(n==2) {
            System.out.println(Math.max(cnt[1][0], cnt[1][1]));
            return;
        }
        cnt[2][0] = stairs[0] + stairs[2];
        for(int i=0;i<n-1;i++) {
            tmp = cnt[i];
            cnt[i+1][1] = Math.max(cnt[i+1][1], tmp[0]+stairs[i+1]);
            
            if(i<n-2) {
                cnt[i+2][0] = Math.max(cnt[i+2][0], tmp[0]+stairs[i+2]);
                cnt[i+2][0] = Math.max(cnt[i+2][0], tmp[1]+stairs[i+2]);
            }
        }
        System.out.println(Math.max(cnt[n-1][0], cnt[n-1][1]));
    }
}
