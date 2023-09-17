package YeonChanLim.Week12.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int N,K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        if(N==K) {
            System.out.println(0);
        }else {
            bfs(N);
        }

        br.close();
    }

    static void bfs(int num) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visit[num] = 1;

        while(!queue.isEmpty()) {
            int tmp=queue.poll();
            for(int i=0; i < 3; i++) {
                int next;
                if(i==0) {
                    next=tmp+1;
                }else if(i==1) {
                    next=tmp-1;
                }else {
                    next=tmp*2;
                }
                if(next==K) {
                    System.out.println(visit[tmp]);
                    return;
                }
                if (next >= 0 && next < visit.length && visit[next] == 0) {
                    queue.add(next);
                    visit[next] = visit[tmp] + 1;
                }
            }
        }
    }
}
