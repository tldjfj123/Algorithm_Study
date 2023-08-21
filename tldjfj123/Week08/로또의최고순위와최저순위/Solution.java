package 로또의최고순위와최저순위;

import java.util.HashSet;

/**
 * - 모르는 번호에 대해서는 전부 다 맞는 경우와 전부 다 틀린 경우만 고려하면 되겠구나!!
 * 1. HashSet과 retainsAll 메소드를 사용하여 lotto 와 win_nums 교집합(기존 번호 중 맞는 번호 갯수)을 구한다!!
 * 2. 모르는 번호가 전부 맞는 경우, 모르는 번호가 전부 틀린 경우의 등수를 return 하면 답이겠구나!!
 *
 * 1등 : 6개
 * 2등 : 5개
 * 3등 : 4개
 * 4등 : 3개
 * 5등 : 2개
 * 6등 : 꽝
 */

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> myLotto = new HashSet<>();
        HashSet<Integer> winLotto = new HashSet<>();

        int[] answer = new int[2];
        int zeros = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeros++;
            } else {
                myLotto.add(lottos[i]);
            }
        }

        for (int i = 0; i < win_nums.length; i++) {
            winLotto.add(win_nums[i]);
        }

        //교집합 찾기 -> myLotto가 교집합으로 변경됨
        myLotto.retainAll(winLotto);


        //max
        if (myLotto.size() + zeros > 1) {
            answer[0] = 7 - myLotto.size() - zeros;
        } else {
            answer[0] = 6;
        }

        //min
        if (myLotto.size() > 1) {
            answer[1] = 7 - myLotto.size();
        } else {
            answer[1] = 6;
        }

        return answer;
    }
}