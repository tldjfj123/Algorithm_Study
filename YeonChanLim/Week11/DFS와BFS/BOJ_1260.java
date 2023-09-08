package YeonChanLim.Week11.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
일단 이제 문제 풀면 BufferedReader랑 StringTokenizer는 그냥 박아놓고 시작함...ㅋㅋㅋㅋ
https://deftkang.tistory.com/215 -> buffered, string

StringTokenizer를 쓰는게 특정 문자열 읽으려고???

문제
DFS-깊이 우선 탐색
1 2
1 3
1 4
2 4
3 4
가 들어왔는데 처음에 1 2 가 들어오면
그 다음에 2 4 그 다음에 이어지는게 없으니 1 3 -> 3 4 이런식으로 탐색
BFS - 넓이 우선 탐색
1 2
1 3
1 4
2 4
3 4
이렇게 탐색
 */

public class BOJ_1260 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;

    static int node, line, start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        // 여기서 arr는 노드 간 간선을 표현해 주기 위함(인접 행렬 방법)
        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        //sb.append("\n");
        dfs(start);
        sb.append("\n");
        check = new boolean[node+1];

        bfs(start);

        System.out.println(sb);

    }

    // 재귀를 활용한 dfs
    // dfs 시작점을 주는데 check boolean 배열을 사용해 체크
    // arr == 1이면 간선 o, 그 다음 check가 false라면 탐색하지 않은 노드
    // for문이 0부터 시작하니까 해당 노드에 걸리면 dfs가 실행!!
    public static void dfs(int start) {

        check[start] = true;
        sb.append(start + " ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }

    }

    // bfs
    // 큐 또한 시작 노드, 큐에는 해당 노드 넣어준 다음에 탐색 시작
    // 큐의 처음 삽입한 노드를 빼주고 그 노드와 연결되어있는 (ARR 배열) 노드들을 탐색하여 Q에 삽입
    // 이러한 큐를 반복해서 꺼내 주다가 큐가 비어지면 끝!!
    public static void bfs(int start) {
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start + " ");

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }


    }

}
