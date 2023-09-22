package BOJ1927;

/*
 * 최소 힙
 * 우선순위 큐. 끝.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine()), input;
        for(int i=0;i<n;i++) {
            input = Integer.parseInt(br.readLine());
            if(input==0)    System.out.println(q.isEmpty() ? 0 : q.poll());
            else            q.offer(input);
        }
    }
}
