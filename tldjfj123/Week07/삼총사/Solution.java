package 삼총사;

class Solution {
    public int solution(int[] number) {
        int res = 0;
        
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
}