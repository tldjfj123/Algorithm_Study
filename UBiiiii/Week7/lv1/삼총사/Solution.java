package UBiiiii.Week7.lv1.삼총사;

class Solution {
    static boolean[] isUsed;
    public int solution(int[] number) {
        isUsed = new boolean[number.length];
        int answer = bfs(number, 0, 0, 0);
        return answer;
    }
    
    private int bfs(int[] number, int total, int cnt, int pre) {
        if(cnt==3) {
            return total==0 ? 1 : 0;
        }
        
        int n = 0;
        for(int i=pre;i<isUsed.length;i++) {
            if(isUsed[i])   continue;
            
            isUsed[i] = true;
            n += bfs(number, total+number[i], cnt+1, i);
            isUsed[i] = false;
        }
        return n;
    }
}