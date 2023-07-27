package 개인정보수집유효기간;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> check = new ArrayList<>();
        Map<String, Integer> type = new HashMap<>();
        String[] date = today.split("\\.");
        
        for(String t : terms) {
            String[] term = t.split(" ");
            type.put(term[0], Integer.parseInt(term[1]));
        }
        
        for(int i=0;i<privacies.length;i++) {
            String[] p = privacies[i].split(" ");
            String[] d = p[0].split("\\.");
            int[] gap = new int[3];
            boolean flag = false;

            for(int j=0;j<3;j++) {
                gap[j] = Integer.parseInt(d[j]) - Integer.parseInt(date[j]);
            }
            
            if(gap[2] < 0) {
                gap[1] -= 1;
                gap[2] += 28;
            }
            
            gap[1] += type.get(p[1]);
            if(gap[1] < 0) {
                gap[0] -= 1;
                gap[1] += 12;
            } else if(gap[1] >= 12) {
                int n = gap[1]/12;
                gap[0] += n;
                gap[1] -= n*12;
            }
            
            for(int g : gap) {
                if(g > 0)  {
                    flag = false;
                    break;
                } else {
                    flag = true;
                    if(g < 0)   break;
                }
            }
            
            if(flag)    check.add(i);
        }
        
        answer = new int[check.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = check.get(i)+1;
        }
        
        return answer;
    }
}