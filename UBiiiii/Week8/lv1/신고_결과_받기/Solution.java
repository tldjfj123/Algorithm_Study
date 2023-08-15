package UBiiiii.Week8.lv1.신고_결과_받기;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    static Map<String, Set<String>> cnt = new HashMap<>();
    static Set<String> tmp;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for(String id : id_list)    cnt.put(id, new HashSet<>());
        for(String r : report) {
            String[] rs = r.split(" ");
            tmp = cnt.get(rs[1]);
            tmp.add(rs[0]);
            cnt.put(rs[1], tmp);
        }
        for(String key : cnt.keySet()) {
            tmp = cnt.get(key);
            if(tmp.size() >= k) for(String id : tmp) answer[Arrays.asList(id_list).indexOf(id)]++;
        }
        return answer;
    }
    
    
}