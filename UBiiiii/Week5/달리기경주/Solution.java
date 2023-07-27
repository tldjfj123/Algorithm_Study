package 달리기경주;

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        for(String player : players) {
            map.put(player, i);
            answer[i++] = player;
        }
        
        for(String player: callings) {
            int idx = map.get(player);
            
            if(idx==0) continue;
            String tmp = answer[idx-1];
            answer[idx-1] = answer[idx];
            answer[idx] = tmp;
            map.put(player, idx-1);
            map.put(tmp, idx);
        }
        return answer;
    }
}