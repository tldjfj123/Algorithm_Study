package UBiiiii.Week8.lv1.로또의_최고_순위와_최저_순위;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeros = 0, min=0, max=0;
        for(int l : lottos) {
            if(l==0)    zeros++;
            else for(int n : win_nums)  if(n==l) {
                min++;
                break;
            }
        }
        min = Math.min(6, 7-min);
        max = Math.max(1, min - zeros);
        return new int[] {max, min};
    }
}