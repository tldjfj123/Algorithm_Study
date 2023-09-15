package UBiiiii.Week12.BOJ1463;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] cnt = new int[input+1], tmp = new int[3];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr==input) {
                System.out.println(cnt[curr]);
                return;
            }
            tmp[0] = curr+1;
            tmp[1] = curr*2;
            tmp[2] = curr*3;
            for(int n : tmp) {
                if(n<=input && cnt[n]==0) {
                    cnt[n] = cnt[curr]+1;
                    q.offer(n);
                }
            }
        }
    }
}