package 카잉달력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 달력 형태 : 1 ~ m 무한반복, 1 ~ n 무한반복
 * -> modula 연산을 이용
 * -> 연산의 최댓값은 최소공배수
 * -> 어찌됐든 O(MN)이라 1초안에 못하는구나 ㅆㅂ -> 다른 방법이 필요하다
 *
 * 다른방법 : x를 고정하고 나머지 연산을 통해서 답을 도출해낸다
 */

public class Main {
    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    // 최소공배수(LCM) 계산 함수
    public static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            boolean isDone = false;
            
            for (int j = x; j < getLCM(m, n); j+= m){
                if (j % n == y) {
                    System.out.println(j + 1);
                    isDone = true;
                    break;
                }
            }
            
            if (!isDone) {
                System.out.println(-1);
            }

        }

    }
}
