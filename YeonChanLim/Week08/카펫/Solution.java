package YeonChanLim.Week08.카펫;

import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};

        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0) {
                answer[0] = yellow / i + 2; //가로가 세로보다 커야 하므로
                answer[1] = i + 2; // 세로 길이를 저장
                if (answer[0] * answer[1] - i * yellow / i == brown) // 주어진 조건을 만족하는지 확인 (타일의 가로 * 세로) - (yellow 가로 * 세로) = brown 타일 개수
                    return (answer); // 만족하면 결과 배열 반환
            }
        }
        return answer;
    }
}
