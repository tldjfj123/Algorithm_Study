package YeonChanLim.Week10.nx2타일링;

/*
n = 4 일때 5개인것 까지 알고 있고 n = 5일때를 노트에다가 노가다좀 뛰어보니

n = 1 -> 1개
n = 2 -> 2개
n = 3 -> 3개
n = 4 -> 5개
n = 5 -> 8개

1 - 2- 3 - 5 - 8 - 13 ~~~
피보나치 수열이라 생각!
 */

class Solution {
    public int solution(int n) {

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            int num = arr[i - 1] + arr[i - 2];
            arr[i] = num % 1000000007;
        }

        return arr[n-1];
    }
}
