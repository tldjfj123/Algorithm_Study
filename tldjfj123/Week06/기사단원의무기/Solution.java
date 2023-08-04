package 기사단원의무기;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        //To solve the time complexity problem, Find the number of divisors up to the maximum value of n in advance
        int[] board = divisor(100000);

        for (int i = 1; i <= number; i++) {
            if (board[i] > limit) {
                answer += power;
            } else {
                answer += board[i];
            }
        }

        return answer;
    }


    //Get number of divisor by using Sieve of Eratosthenes
    public int[] divisor(int n) {
        int[] sieve = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                sieve[j]++;
            }
        }

        return sieve;
    }
}