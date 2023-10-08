package UBiiiii.Week14.BOJ2630;

/*
 * 색종이 만들기
 * dnf 문제
 * 주어진 영역에 대해서 각각 조건에 맞는지 확인하고, 맞으면 끝, 아니면 4분면에 각각 다시 체크
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int blue = 0, white = 0;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0;i<n;i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(el->Integer.parseInt(el)).toArray();
        }
        
        dnc(0, n, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void dnc(int sx, int ex, int sy, int ey) {
        int start = map[sx][sy];
        int half = (ex-sx)/2;
        for(int i=sx; i<ex;i++) {
            for(int j=sy;j<ey;j++) {
                if(map[i][j]!=start) {
                    dnc(sx, sx+half, sy, sy+half);
                    dnc(sx+half, ex, sy, sy+half);
                    dnc(sx, sx+half, sy+half, ey);
                    dnc(sx+half, ex, sy+half, ey);
                    return;
                }
            }
        }

        if(start==0)    white++;
        else            blue++;

        return;
    }

}

