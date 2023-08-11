package UBiiiii.Week7.lv2.조이스틱;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for(int i = 0; i < name.length(); i++) {
            // 조이스틱의 상하 방향 조작 계산
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));

            /*
             * 출처: https://born2bedeveloper.tistory.com/26
             * 이후에 A로 이루어진 문자열이 있을 경우, A 문자열의 시작과 끝 위치 파악
             * 1. A 문자열 시작까지 왔다가 반대 방향으로 이동하는 경우와
             * 2. A 문자열 마지막까지 반대 방향으로 이동하다가 다시 정방향으로 이동하는 경우
             * 두 경우와 정방향으로 그대로 오는 경우(move)를 비교하여 최소로 움직이는 방법 저장
             */
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                move = Math.min(move, i * 2 + (name.length() - endA));
                move = Math.min(move, i + (name.length() - endA) * 2);
            }
        }
        return answer + move;
    }
}
