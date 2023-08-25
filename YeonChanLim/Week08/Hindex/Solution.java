package YeonChanLim.Week08.Hindex;

import java.util.*;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 현재 논문의 인용 횟수 이상을 가지는 논문의 개수

            if (citations[i] >= h) { // 현재 논문의 인용 횟수가 이상을 가지는 논문의 개수보다 크거나 같으면
                answer = h; // 결과 값을 갱신
                break; // 종료
            }
        }

        return answer;
    }
}
