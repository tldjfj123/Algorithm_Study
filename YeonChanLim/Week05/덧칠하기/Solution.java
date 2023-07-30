package YeonChanLim.Week05.덧칠하기;

public class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end = 0;

        for (int num : section) {
            if (end < num) {
                end = num + (m-1);
                answer++;
            }
        }

        return answer;
    }
}
