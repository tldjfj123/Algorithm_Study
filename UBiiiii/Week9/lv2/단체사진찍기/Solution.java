package UBiiiii.Week9.lv2.단체사진찍기;

import java.util.*;

class Solution {
    static int answer;
    static boolean[] isChecked = new boolean[8];
    static char[] member = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static Map<Character, Integer> index = new HashMap<>();
    static Request[] rarr;
    
    public int solution(int n, String[] data) {
        answer = 0;
        rarr = new Request[data.length];
        for(int i=0;i<data.length;i++) {
            String curr = data[i];
            rarr[i] = new Request(curr.charAt(0), curr.charAt(2), curr.charAt(3), Integer.parseInt(curr.substring(4)));
        }

        dfs(0);
        return answer;
    }
    
    private static void dfs(int idx) {
        if(idx==8) {
            for(Request r: rarr) {
                if(!r.checkRequest())   return;
            }
            answer++;
            return;
        }
        
        for(int i=0;i<8;i++) {
            if(isChecked[i])    continue;
            isChecked[i] = true;
            index.put(member[idx], i);
            dfs(idx+1);
            isChecked[i] = false;
        }
    }
    
    private static class Request {
        private char from, to, how;
        private int len;
        
        public Request(char from, char to, char how, int len) {
            this.from = from;
            this.to = to;
            this.how = how;
            this.len = len;
        }
        
        public boolean checkRequest() {
            int fromIdx = index.get(this.from);
            int toIdx = index.get(this.to);
            switch(this.how) {
                case '>' :
                    return Math.abs(fromIdx - toIdx) - 1 > this.len;
                case '<' :
                    return Math.abs(fromIdx - toIdx) - 1 < this.len;
                default :
                    return Math.abs(fromIdx - toIdx) - 1 == this.len;
            }
        }
        
        @Override
        public String toString() {
            return "from: "+from+", to: "+to+", how: "+how+", len: "+len;
        }
    }
}