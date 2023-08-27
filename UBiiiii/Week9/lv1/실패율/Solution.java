package UBiiiii.Week9.lv1.실패율;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[] users = new float[N+1], sum = new float[N+1];
        Queue<Stage> pq = new PriorityQueue<>();
        for(int s : stages) users[s-1]++;
        
        sum[N] = users[N];
        for(int i=N-1;i>-1;i--)   sum[i] = users[i] + sum[i+1];
        
        for(int i=0;i<N;i++)    pq.offer(new Stage(i+1, sum[i]==0 ? 0 : users[i]/sum[i]));
        for(int i=0;i<N;i++)    answer[i] = pq.poll().n;
        
        return answer;
    }
    
    private static class Stage implements Comparable<Stage>{
        int n;
        float per;
        
        Stage(int n, float per) {
            this.n = n;
            this.per = per;
        }
        
        @Override
        public int compareTo(Stage s) {
            return this.per - s.per == 0 ? this.n - s.n : (this.per < s.per ? 1 : -1);
        }
    }
}