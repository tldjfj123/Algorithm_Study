package YeonChanLim.Week08.로또의최고순위와최저순위;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int accord = 0;
        int zero = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        // 로또 번호와 당첨 번호를 비교하며 일치하는 번호와 0의 개수 계산
        for(int lotto : lottos){
            if(Arrays.binarySearch(win_nums, lotto) >= 0)
                accord++;  // 일치하는 번호가 있는 경우 일치 번호 개수 증가
            if(lotto == 0)
                zero++; // 0인 번호가 있는 경우 0의 개수 증가
        }

        answer[1] = Math.min(7 - accord, 6);

        answer[0] = Math.min(7-(accord + zero), 6);

        return answer;
    }
}
