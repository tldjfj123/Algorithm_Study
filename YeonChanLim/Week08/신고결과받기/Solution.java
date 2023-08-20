package YeonChanLim.Week08.신고결과받기;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];  // 신고 수 저장 배열

        // 신고 대상 저장
        Map<String, HashSet<String>> map = new HashMap<>();

        // 인덱스 저장
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());  // 신고한 대상을 저장할 빈 집합 생성
            idxMap.put(name, i);  // 사용자 인덱스를 맵에 저장
        }

        // 신고 내역을 처리하며 맵 갱신
        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];  // 신고한 사용자
            String to = str[1];    // 신고당한 사용자
            map.get(to).add(from);  // 신고당한 사용자의 신고 대상 목록에 신고한 사용자 추가
        }

        // 각 사용자의 신고한 대상을 확인하며 k번 이상 신고한 경우 처리
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);  // 해당 사용자가 신고한 대상 목록
            if (send.size() >= k) {  // k번 이상 신고한 경우
                for (String name : send) {
                    answer[idxMap.get(name)]++;  // 신고당한 사용자의 신고 수 증가
                }
            }
        }

        return answer;
    }
}
