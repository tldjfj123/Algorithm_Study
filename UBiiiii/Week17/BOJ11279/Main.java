package BOJ11279;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int i=0;i<n;i++) {
      int tmp = sc.nextInt();
      if(tmp==0)  sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
      else        pq.offer(tmp);
    }

    if(sb.length()>0) System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
    sc.close();
  }
}
