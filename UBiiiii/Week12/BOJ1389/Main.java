package UBiiiii.Week12.BOJ1389;

/*
 * 케빈 베이컨의 6단계 법칙
 * 주요 풀이 : BFS를 하면서 거리를 저장하자 -> 다익스트라랑 비슷하다고 해야하나
 * 케빈 베이컨 수가 가장 작은 사람을 출력하라 -> 각 사람에 대해서 전체 케빈 베이컨 수를 구해야 한다.
 * 한 사람과 연관된 사람은 Map에 각 사람마다 리스트를 할당해자(사실 정렬할 게 아니라서 Map을 쓰든 set을 쓰든 비슷했을 수 있다.)
 * 주어진 단방향 관계를 양방향으로(앞뒤를 바꿔서) Map에 매번 저장한다
 * 마지막으로 각각을 시작점으로 하는 bfs를 통해 베이컨 수를 계산하고, 이를 배열에 저장한다.
 * 1. 처음에는 다익스트라를 생각해서 작성했는데, 작성하고 보니까 다익스트라랑은 별로 관련없는 거 같다. 최소값 찾기 등의 과정이 빠져서 그런 걸 수도
 * 2. 알고리즘 분류에서 플로이드-워셜 이라고 써있는데, 이건 나중에 찾아보자
 */

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
