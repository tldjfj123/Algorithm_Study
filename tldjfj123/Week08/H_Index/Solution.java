package H_Index;

import java.util.Arrays;

/**
 * 1. citations 배열을 오름차순으로 정렬.
 * 2. for 문을 돌면서 각각을 기준으로 인용 횟수를 세고, 최댓값을 갱신해주면서 조건에 맞으면 return
 */


class Solution {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;


        int min = citations[0];
        int max = citations[citations.length-1];

        for (int c = 0; c <= max; c++) {
            int high = 0;
            int low = 0;

            for (int i = 0; i < citations.length; i++) {
                if (citations[i] > c) {
                    high++;
                } else if (citations[i] < c){
                    low++;
                } else {
                    high++;
                    low++;
                }
            }

            if (high >= c && low <= c) {
                answer = Math.max(answer, c);
            }
        }


        return answer;
    }
}