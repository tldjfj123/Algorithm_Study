package 대충만든자판;

import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int idx, cnt;
        boolean flag;
        int[] answer = new int[targets.length];
        
        String[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        int[] map = new int[alpha.length];
        Arrays.fill(map, 101);
        
        for(String key : keymap) {
            String[] k = key.split("");
            for(int i=0; i<k.length; i++) {
                idx = Arrays.asList(alpha).indexOf(k[i]);
                if(map[idx] > i)    map[idx] = i;
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            cnt = 0;
            flag = false;
            String[] target = targets[i].split("");
            for(String t : target) {
                idx = Arrays.asList(alpha).indexOf(t);
                if(map[idx] == 101) {
                    flag = true;
                    break;
                } else cnt += map[idx]+1;
            }
            if(flag)    answer[i] = -1;
            else        answer[i] = cnt;
        }
        
        
        return answer;
    }
}