package 둘만의암호;


class Solution {
    public String solution(String s, String skip, int index) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char std = s.charAt(i);
            int cnt = 0;

            while (cnt < index) {
                std++;
                if ((int) std > 122) { // 스킵하다가 122(소문자 'z')를 초과한 경우
                    std -= 26;
                }

                int check = skip.indexOf(std);
                if (check == -1) { // 스킵할 문자가 없는 경우
                    cnt++;
                }
            }



            result += Character.toString(std);
        }

        return result;
    }
}