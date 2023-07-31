package 달리기경주;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        int i = 0;

        for (String p : players) {
            rank.put(p, i);
            i++;
        }

        for (String c : callings) {
            int idx = rank.get(c);

            if (idx != 0) {
                String temp = players[idx];
                players[idx] = players[idx - 1];
                players[idx - 1] = temp;

                rank.put(players[idx], idx);
                rank.put(players[idx - 1], idx - 1);
            }
        }

        return players;
    }
}
