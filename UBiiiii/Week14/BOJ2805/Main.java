package UBiiiii.Week14.BOJ2805;

/*
 * 나무 자르기
 * 원하는 길이 이상으로 구할 수 있는 최대 높이를 찾아보자
 * 1. 맨 위부터 높이를 1씩 낮춰가면서 탐색하기 -> 시간복잡도 폭발
 * 2. 이분탐색 방식으로 접근하기 -> 최종 높이에서 목표 길이만큼 못 자를 수도 있고, 최대 높이가 아닐 수도 있다.
 * -> 반복문 2개를 이용해서 두 조건(목표 길이만큼 구하기, 최대 높이 구하기) 처리
 */

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    long answer, gap, tmp;
    long[] tree;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    tree = Arrays.stream(br.readLine().split(" ")).mapToLong(el->Long.parseLong(el)).sorted().toArray();
    answer = tree[n-1];
    gap = answer/2;
    while(gap>0) {
      tmp = getWood(tree, answer);
      if(tmp >= m)  answer += gap;
      else          answer -= gap;
      gap /= 2;
    }

    while(true) {
      tmp = getWood(tree, answer);
      if(tmp < m && tmp>=0)  answer -= 1;
      else          break;
    }

    while(true) {
      tmp = getWood(tree, answer);
      if(tmp >= m)  answer += 1;
      else          break;
    }

    System.out.println(answer-1);

  }

  private static long getWood(long[] tree, long len) {
    long cnt = 0;
    for(long t : tree) cnt += Math.max(0, t-len);
    return cnt;
  }

}
