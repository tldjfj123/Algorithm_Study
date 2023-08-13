package YeonChanLim.Week07.성격유형검사하기;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";  // 최종 결과를 저장할 변수를 초기화
        char[] alpa = new char[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};  // 성격 유형을 나타내는 문자 배열
        int[] type = new int[4];  // RT CF JM AN 각 유형에 대한 점수를 저장할 배열

        // 주어진 설문조사 결과와 선택된 점수(choices)를 기반으로 각 유형의 점수를 계산
        for (int i = 0; i < choices.length; i++) {
            if (survey[i].equals("NA")) {
                type[3] -= (choices[i] - 4);
            }
            if (survey[i].equals("AN")) {
                type[3] += (choices[i] - 4);
            }
            if (survey[i].equals("MJ")) {
                type[2] -= (choices[i] - 4);
            }
            if (survey[i].equals("JM")) {
                type[2] += (choices[i] - 4);
            }
            if (survey[i].equals("FC")) {
                type[1] -= (choices[i] - 4);
            }
            if (survey[i].equals("CF")) {
                type[1] += (choices[i] - 4);
            }
            if (survey[i].equals("TR")) {
                type[0] -= (choices[i] - 4);
            }
            if (survey[i].equals("RT")) {
                type[0] += (choices[i] - 4);
            }
        }

        // 계산된 유형 점수를 바탕으로 성격 유형을 판단하여 결과 문자열을 생성
        for (int j = 0; j < 4; j++) {
            if (type[j] < 0) {
                answer += alpa[j * 2];  // 음수면 첫 번째 성격 유형을 추가
            } else if (type[j] > 0) {
                answer += alpa[j * 2 + 1];  // 양수면 두 번째 성격 유형을 추가
            } else {
                answer += alpa[j * 2];  // 0이면 첫 번째 성격 유형을 추가
            }
        }
        return answer;
    }
}
