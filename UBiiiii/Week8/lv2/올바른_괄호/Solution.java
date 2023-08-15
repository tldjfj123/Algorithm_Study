package UBiiiii.Week8.lv2.올바른_괄호;

class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='(')   cnt++;
            if(c==')')   cnt--;
            
            if(cnt<0)   return false;
        }
        
        return cnt==0;
    }
}