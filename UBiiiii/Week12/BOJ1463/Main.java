package UBiiiii.Week12.BOJ1463;

/*
 * 1로 만들기
 * 주요 풀이 : 각 케이스 별 노가다...?
 * 정수 X를 각 케이스별로 계산해서 추가로 한다 -> 1부터 그냥 다 세는 건 어때?
 * 1부터 시작해서 Queue에 집어넣는다. 그리고 각각의 수에 도달했을 때 몇 단계를 거쳤는지 저장할 cnt 배열을 생성한다.
 * 해당 수에 아직 도달하지 않았을 때(cnt 값이 0일 때) 3개의 케이스에 대해서 계산하여 Queue에 집어넣는다.
 * 세 가지 케이스가 무조건 커지는 케이스이므로 목표값보다 커지는 경우는 제외한다.(작아질 일이 없으니 넘어가면 목표값은 못간다).
 * Queue에서 목표값이 나오는 순간에 해당 값에 저장된 단계 수를 출력한다.
 * 1. 의외로 시간초과가 안나더라. 세 케이스가 커지기만 해서 그런가?
 * 2. 알고리즘 분류에 DP라고 되있는데, 솔직히 아직도 DP가 뭔지 모르겠다. 이건 공부해봐야겠다.
 */

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