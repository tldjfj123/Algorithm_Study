package YeonChanLim.Week12.케빈베이컨의6단계법칙;

/*
문제 읽어보고 그래프 탐색같다고 생각하고 문제 설명 아래쪽에
유형 보니까 플로이드–워셜을 봄..
처음들어보는 용어라 서치
- 모든 최단 경로를 구하는 알고리즘
참고 사이트 : https://chanhuiseok.github.io/posts/algo-50/
https://velog.io/@jhno96/JAVA-%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%99%80%EC%83%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389 {
    static int N, M;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;

                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
        //------------------------------------------------

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        // 플로이드-워셜 알고리즘 적용
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int res = INF;
        int idx = -1;

        // 케빈 베이컨의 수가 가장 작은 인덱스를 탐색
        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += arr[i][j];
            }

            if (res > total) {
                res = total;
                idx = i;
            }
        }

        System.out.println(idx);
    }
}



