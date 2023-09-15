package UBiiiii.Week12.BOJ1697;

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

            if(tmp+1<200_000 && len[tmp+1]==0) {
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
