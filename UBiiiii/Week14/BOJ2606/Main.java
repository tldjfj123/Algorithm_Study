package UBiiiii.Week14.BOJ2606;

/*
 * 바이러스
 * 끝까지 돌리는 bfs
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        boolean[] isChecked;
        int n, m, a, b, tmp, cnt=0;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        isChecked = new boolean[n+1];
        for(int i=1;i<=n;i++) {
            map.put(i, new ArrayList<>());
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        q.offer(1);
        isChecked[1] = true;
        while(!q.isEmpty()) {
            tmp = q.poll();
            cnt++;
            for(int i : map.get(tmp)) {
                if(!isChecked[i]) {
                    isChecked[i] = true;
                    q.offer(i);
                }
            }
        }

        System.out.println(cnt-1);
    }

}

