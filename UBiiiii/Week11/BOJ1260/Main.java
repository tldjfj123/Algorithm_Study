package BOJ1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] isChecked;
    private static List<Integer>[] node;
    public static void main(String[] args) throws IOException {
        int n, r, start, a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        isChecked = new boolean[n];
        node = new List[n];

        for(int i=0;i<n;i++)    node[i] = new ArrayList<>();
        for(int i=0;i<r;i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            node[a].add(b);
            node[b].add(a);
            node[a].sort((c1,c2)->c1-c2);
            node[b].sort((c1,c2)->c1-c2);
        }

        dfs(start-1);
        System.out.println(sb.replace(sb.length()-1,sb.length(),"").toString());
        bfs(start-1);
        System.out.println(sb.replace(sb.length()-1,sb.length(),"").toString());

    }

    private static void dfs(int i) {
        isChecked[i] = true;
        sb.append(i+1).append(" ");
        for(int num : node[i]) {
            if(!isChecked[num]) dfs(num);
        }

        return;
    }

    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> tmp;
        sb = new StringBuilder();
        isChecked = new boolean[isChecked.length];
        q.offer(i);
        isChecked[i] = true;
        while(!q.isEmpty()) {
            sb.append(q.peek()+1).append(" ");
            tmp = node[q.poll()];
            for(int num : tmp) {
                if(!isChecked[num]) {
                    isChecked[num] = true;
                    q.offer(num);
                }
            }
        }
        
        return;
    }
}
