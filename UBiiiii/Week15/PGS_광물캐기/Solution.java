package UBiiiii.Week15.PGS_광물캐기;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public int solution(int[] picks, String[] minerals) {
    int answer = 0, cnt = 0;

    for (int i = 0; i < picks.length; i++)
      cnt += picks[i];
    Map<String, Integer> dc = new HashMap<>();
    Map<String, Integer> ic = new HashMap<>();
    Map<String, Integer> sc = new HashMap<>();

    dc.put("diamond", 1);
    dc.put("iron", 1);
    dc.put("stone", 1);
    ic.put("diamond", 5);
    ic.put("iron", 1);
    ic.put("stone", 1);
    sc.put("diamond", 25);
    sc.put("iron", 5);
    sc.put("stone", 1);

    PriorityQueue<Block> q = new PriorityQueue<>();

    for (int i = 0; i < cnt; i++) {
      int tcnt = 0;
      for (int j = i * 5; j < (i + 1) * 5; j++) {
        if (j >= minerals.length) break;
        tcnt += (minerals[j].equals("diamond") ? 3 : (minerals[j].equals("iron") ? 2 : 1));
      }
      q.offer(new Block(i, tcnt));
    }

    while (!q.isEmpty() && cnt>0) {
      Block curr = q.poll();
      System.out.println("stage: "+curr.stage);
      if (picks[0] > 0) {
        for (int i = curr.stage * 5; i < (curr.stage + 1) * 5; i++) {
          if (i >= minerals.length) break;
          answer += dc.get(minerals[i]);
        }
        picks[0]--;
        cnt--;
      } else if (picks[1] > 0) {
        for (int i = curr.stage * 5; i < (curr.stage + 1) * 5; i++) {
          if (i >= minerals.length) break;
          answer += ic.get(minerals[i]);
        }
        picks[1]--;
        cnt--;
      } else if (picks[2] > 0) {
        for (int i = curr.stage * 5; i < (curr.stage + 1) * 5; i++) {
          if (i >= minerals.length) break;
          answer += sc.get(minerals[i]);
        }
        picks[2]--;
        cnt--;
      }
    }

    return answer;
  }

  private static class Block implements Comparable<Block> {
    int stage;
    int cost;

    Block(int stage, int cost) {
      this.stage = stage;
      this.cost = cost;
    }

    @Override
    public int compareTo(Block o) {
      return o.cost - this.cost;
    }

  }
}
