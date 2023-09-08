package YeonChanLim.Week11.Z;

/*
재귀적으로 순서대로 방문한다 -> 재귀를 사용해야 하는구나!
배열을 사분면으로 나누고, 입력받은 r, c가 몇 번째 사분면에 속하는지
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        int count = find(size, r, c);
        System.out.println(count);
    }

    private static int find(int size, int r, int c) {
        if (size == 1)
            return 0;

        int half = size / 2;
        if (r < half && c < half) {
            return find(half, r, c);
        } else if (r < half && c >= half) {
            return half * half + find(half, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + find(half, r - half, c);
        } else {
            return 3 * half * half + find(half, r - half, c - half);
        }
    }
}
