package YeonChanLim.Week06.푸드파이트대회;

class Solution {
    public String solution(int[] food) {
        String answer = "0";

        // 뒤에서부터 순회
        for(int i = food.length -1; i > 0; i--){
            for(int j = 0; j < food[i]/2; j++){
                answer = i + answer + i;
            }
        }
        return answer;
    }
}
