package 푸드파이터대회;

class Solution {
    public String solution(int[] food) {
        String answer = "0";
        for(int i=1; i<food.length; i++)    answer+=Integer.toString(i).repeat(food[i]/2);
        return answer + "0" + new StringBuffer(answer).reverse().toString();
    }
}