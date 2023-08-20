package YeonChanLim.Week08.로또의최고순위와최저순위;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int accord = 0;
        int zero = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for(int lotto : lottos){
            if(Arrays.binarySearch(win_nums, lotto) >= 0)
                accord++;
            if(lotto == 0)
                zero++;
        }
        answer[1] = Math.min(7 - accord, 6);

        answer[0] = Math.min(7-(accord + zero), 6);

        return answer;
    }
}
