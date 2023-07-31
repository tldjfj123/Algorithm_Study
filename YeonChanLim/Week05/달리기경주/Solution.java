package YeonChanLim.Week05.달리기경주;

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (String s : callings) {
            int rank = map.get(s);
            map.put(s, rank - 1);
            map.put(players[rank - 1], rank);
            players[rank] = players[rank -1];
            players[rank -1] = s;
        }
        return players;
    }
}
