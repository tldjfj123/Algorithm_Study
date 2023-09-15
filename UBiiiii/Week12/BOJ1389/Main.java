package UBiiiii.Week12.BOJ1389;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m, a, b, min = Integer.MAX_VALUE;
        int[] len, score, curr;
        boolean[] isChecked;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        score = new int[n];
        m = Integer.parseInt(st.nextToken());
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            List<Integer> alst = map.getOrDefault(a, new ArrayList<>());
            alst.add(b);
            map.put(a, alst);
            List<Integer> blst = map.getOrDefault(b, new ArrayList<>());
            blst.add(a);
            map.put(b, blst);
        }

        for(int i=0;i<n;i++) {
            isChecked = new boolean[n];
            len = new int[n];
            isChecked[i] = true;
            q.offer(new int[] {i, 0});
            while(!q.isEmpty()) {
                curr = q.poll();
                len[curr[0]] = curr[1];
                List<Integer> tmp = map.getOrDefault(curr[0], new ArrayList<>());
                for(int node : tmp) {
                    if(!isChecked[node]) {
                        isChecked[node] = true;
                        q.offer(new int[] {node, curr[1]+1});
                    }
                }
            }
            for(int j=0;j<len.length;j++) score[i] += len[j];
            min = Math.min(min, score[i]);
        }

        for(int i=0;i<n;i++)    if(score[i]==min)   {
            System.out.println(i+1);
            return;
        }
    }
}
