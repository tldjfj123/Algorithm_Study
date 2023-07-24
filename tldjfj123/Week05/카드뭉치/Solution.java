package 카드뭉치;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Idx = 0;
        int cards2Idx = 0;

        ArrayList<String> result = new ArrayList<>();

        for(String g : goal) {
            if(g.equals(cards1[cards1Idx])) {
                if(cards1Idx < cards1.length-1) {
                    cards1Idx++;
                }
                result.add(g);
            } else if (g.equals(cards2[cards2Idx])) {
                if(cards2Idx < cards2.length-1) {
                    cards2Idx++;
                }
                result.add(g);
            }
        }

        if (Arrays.equals(goal, result.toArray())) {
            return "Yes";
        } else {
            return "No";
        }
    }
}