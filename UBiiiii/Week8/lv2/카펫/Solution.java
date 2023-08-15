package UBiiiii.Week8.lv2.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=1; i<=yellow; i++) 
            if(yellow%i==0 && (i+2)*(yellow/i + 2)-yellow == brown)
                return new int[] {yellow/i + 2, i + 2};
        return new int[] {};
    }
}