package BOJ1260;

/*
 * dfs와 bfs를 쓰는 문제니까 dfs와 bfs를 써주자
 * 탐색 시에 숫자가 작은 노드부터 탐색해야 하므로 list 배열을 이용해서 각 노드 별 연결된 노드 리스트 관리 -> 추가할 때마다 정렬하자
 */

import java.io.*;
import java.util.*;

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
