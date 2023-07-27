package 카드뭉치;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int idx1 = 0;
        int idx2 = 0;
        boolean flag = false;
        
        for(String word : goal) {
            if(idx1 < cards1.length && cards1[idx1].equals(word)) idx1++;
            else if(idx2 < cards2.length && cards2[idx2].equals(word))  idx2++;
            else flag = true;
        }
        
        return flag ? "No" : "Yes";
    }
}