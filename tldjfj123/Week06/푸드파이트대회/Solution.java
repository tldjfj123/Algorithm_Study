package 푸드파이트대회;

class Solution {
    public String solution(int[] food) {
        // Divide the number of food by two
        for (int i = 0; i < food.length; i++) {
            food[i] /= 2;
        }

        // left player
        String left = "";
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i]; j++) {
                left += i;
            }
        }

        //right player
        String right = "";
        for (int i = food.length - 1; i > -1; i--) {
            for (int j = 0; j < food[i]; j++) {
                right += i;
            }
        }

        return left + "0" + right;
    }
}