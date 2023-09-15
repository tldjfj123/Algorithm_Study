package UBiiiii.Week12.BOJ1697;

/*
 * 숨바꼭질
 * 주요 풀이 : 컴퓨터는 생각보다 멍청하지만 생각보다 더 빠른 놈이다
 * 형의 현재 위치로부터 동생까지 갈 수 있는 모든 케이스를 다 계산해보자(앞에서 푼 BOJ1463 "1로 만들기"와 동일한 풀이)
 * 처음에는 동생 위치를 넘어가지 않게 제한을 뒀는데, 동생보다 앞으로 텔타고 뒤로 가는 게 빠른 케이스도 있겠더라 -> 그냥 최대값 주고 썼다
 * 1. 이건 뭐 할 말이 없다. 앞에 푼 1463이랑 풀이도 똑같고, 더 어려운 조건도 없고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m, tmp;
        int[] len;
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        len = new int[200_000];
        q.offer(n);
        while(!q.isEmpty()) {
            tmp = q.poll();

            if(tmp==m)  {
                System.out.println(len[tmp]);
                return;
            }
            if(tmp-1>-1 && len[tmp-1]==0) {
                len[tmp-1] = len[tmp]+1;
                q.offer(tmp-1);
            }

            if(tmp+1<=m && len[tmp+1]==0) {
                len[tmp+1] = len[tmp]+1;
                q.offer(tmp+1);
            }

            if(tmp*2<200_000 && len[tmp*2]==0) {
                len[tmp*2] = len[tmp]+1;
                q.offer(tmp*2);
            }
        }
    }
}
