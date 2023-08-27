package YeonChanLim.Week09.나라의숫자;

/*
숫자 3개로만 가지고 노니까 3진법?
%를 사용하면 1, 2, 0 나오는데
이걸 배열로 만들어줌
 */

class Solution {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            // 다음 자리를 처리하기 위해 숫자 n을 3으로 나누고 1을 빼줌
            // 3진법의 각 자리 수는 0부터 시작하지 않고 1부터 시작하기 때문에 1을 빼주는 것
            n = (n - 1) / 3;
        }
        return answer;
    }
}
