package 개인정보수집유효기간;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        // 기간 HashMap 등록
        HashMap<String, Integer> map = new HashMap<>();
        for (String t : terms) {
            String type = t.split(" ")[0];
            Integer term = Integer.valueOf(t.split(" ")[1]);

            map.put(type, term);
        }


        int idx = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (String p : privacies) {
            idx++;
            //날짜, 유형 분리
            String date = p.split(" ")[0];
            String type = p.split(" ")[1];


            //날짜 세부 분리
            Integer year = Integer.valueOf(date.split("\\.")[0]);
            Integer month = Integer.valueOf(date.split("\\.")[1]);
            Integer day = Integer.valueOf(date.split("\\.")[2]);

            //기한 붙이기

            for (int i = 0; i < map.get(type); i++) {
                day += 28;
                //일
                if (day > 28) {
                    day -= 28;
                    month += 1;
                }
                //월
                if (month > 12) {
                    month -= 12;
                    year++;
                }
            }


            String fin = year + "." + month + "." + day;

            //Date 라이브러리를 활용한 비교
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            Date originalDate = dateFormat.parse(today);
            Date compDate = dateFormat.parse(fin);


            if (originalDate.compareTo(compDate) >= 0) {
                result.add(idx);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}