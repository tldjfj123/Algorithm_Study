package 신규아이디추천;


/**
 * 1. 모든 대문자를 소문자로 -> toLowerCase() 메소드 사용
 * 2. 알파벳 소문자, 숫자, -, _ , . 를 제외한 모든 문자 제거 -> String.replaceAll() 메소드 & 정규식 사용
 * 3. 마침표가 2번이상 연속되면 하나의 마침표로 치환 -> String.replaceAll() 메소드 & 정규식 사용
 * 4. 마침표가 처음이나 끝에 존재하면 제거 -> String.replaceAll() 메소드 & 정규식 사용
 * 5. 빈 문자열이 되면, a 대입함.
 * 6. 16자 이상이면, 첫 15개 문자 제외한 나머지 제거 (단, 제거 후 마침표가 끝에 존재하면 끝에 문자 제거)
 * 7. 두글자 이하 일 경우, 끝 문자 3이 될 때 까지 추가
 */

class Solution {
    public String solution(String new_id) {
        // Step 1.
        String step1 = new_id.toLowerCase();

        // Step 2.
        String step2 = step1.replaceAll("[^a-z0-9\\-_.]", "");

        //Step 3. 정규식 {n, m} : n번이상 m번이하 반복
        String step3 = step2.replaceAll("\\.{2,}", ".");

        //Step 4.
        String step4 = step3.replaceAll("^\\.|\\.$", "");

        //Step 5.
        if (step4.length() == 0) {
            step4 += "a";
        }

        //Step 6.
        if (step4.length() >= 16) {
            String tmp = step4.substring(0, 15);
            tmp = tmp.replaceAll("\\.$", "");
            step4 = tmp;
        }

        //Step 7.
        if (step4.length() <= 2) {
            String last = String.valueOf(step4.charAt(step4.length()-1));

            while (step4.length() != 3) {
                step4 += last;
            }
        }

        return step4;

    }
}