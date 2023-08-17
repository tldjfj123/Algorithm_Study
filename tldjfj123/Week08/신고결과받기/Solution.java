package 신고결과받기;

import java.util.*;

class Solution {
    /**
     * 동일 신고는 1개로 처리함 -> HashSet을 이용해야겠구나!
     * 0. HashSet으로 중복 제거해줌
     * 1. id_list를 for문을 돌면서 HashMap에 초기화
     * 2. HashSet을 돌면서 신고자 / 피신고자로 분류하여 count (HashSet의 값 추출 -> List로 형변환)
     * 3. resultMap을 만들고 reportList를 돌면서, 피신고자 기준으로 map을 탐색하여 해당 피신고자가 정지 대상일 경우 resultMap의 신고자에 ++
     */
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> set = new HashSet();

        for (int i = 0; i < report.length; i++) {
            set.add(report[i]);
        }

        HashMap<String, Integer> resultMap = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];

            if (!map.containsKey(id)) {
                map.put(id, 0);
            }

            if (!resultMap.containsKey(id)) {
                resultMap.put(id, 0);
            }
        }

        List<String> reportList = new ArrayList<>(set);

        for (int i = 0; i < reportList.size(); i++) {
            String end = reportList.get(i).split(" ")[1]; //피신고자

            int tmp = map.get(end);
            map.put(end, tmp + 1);
        }

        for (int i = 0; i < reportList.size(); i++) {
            String start = reportList.get(i).split(" ")[0]; //신고자
            String end = reportList.get(i).split(" ")[1]; //피신고자
            int value = map.get(end);

            if (value >= k) {
                int tmp = resultMap.get(start);
                resultMap.put(start, tmp + 1);
            }
        }

        int[] result = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String key = id_list[i];
            result[i] = resultMap.get(key);
        }

        return result;
    }
}