package YeonChanLim.Week11.피보나치함수;

/*
2*n문제도 피보나치라서 비슷할까 했는데 완전 다르넼ㅋㅋㅋㅋ

0이랑 1은 각자 자기 자신이 리턴됨
나머지 2~n은 재귀함수 형태로 매개변수로 n-1, n-2가 전달
ex) fibonacci(2)는 fibonacci(1) + fibonacci(0)이 리턴
    fibonacci(1)은 1이, fibonacci(0)은 0이 리턴되어 fibonacci(2)는 결국 1 + 0 = 2
     fibonacci(1)은 1이 리턴
     총 2 + 1 = 3이 결과값

     수정 내용 - 초기값 대입 부분이랑 38라인 for 문에서 j 시작값을 2로 -> 0으로 하면 음수가 나올수도 있으므로

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            // 피보나치 0,1 연산이 몇번 이뤄지는지 저장하기 위해 배열 두개 선언
            int[] fibonacci0 = new int[41];
            int[] fibonacci1 = new int[41];

            //초기값 대입
            fibonacci0[0] = 1; //매개변수가 0인 경우 fibonacci(0) 연산이 1번
            fibonacci0[1] = 0; //매개변수가 1인 경우 fibonacci(0) 연산이 0번
            fibonacci1[0] = 0; //매개변수가 0인 경우 fibonacci(1) 연산이 0번
            fibonacci1[1] = 1; //매개변수가 1인 경우 fibonacci(1) 연산이 1번

            for (int j = 2; j < N; j++) {
                fibonacci0[j] = fibonacci0[j - 1] + fibonacci0[j - 2];
                fibonacci1[j] = fibonacci1[j - 1] + fibonacci1[j - 2];

            }
            System.out.println(fibonacci0[N] + "" +fibonacci1[N]);
        }
    }
}
