package 다음큰숫자;

/**
 * 정수를 이진수로 -> toBinaryString 메소드 활용 개꿀~~
 * 정말 물리적으로 시작 숫자 다음부터 계산해서 1의 갯수 같으면 return
 */


class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);

        // 기준의 1 갯수 세기
        int one = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                one++;
            }
        }

        while (true) {
            n++;
            String tmp = Integer.toBinaryString(n);

            int tmpone = 0;
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '1') {
                    tmpone++;
                }
            }

            if (one == tmpone) {
                return n;
            }
        }
    }
}