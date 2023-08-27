package 단체사진찍기;

import java.util.HashMap;

class Solution {
    static HashMap<Character, Integer> friend;
    static int list[], answer;
    static boolean isVisited[];
    static String[] s_data;

    static int solution(int n, String[] data) {
        s_data = data;

        friend = new HashMap<Character, Integer>();
        friend.put('A', 0);
        friend.put('C', 1);
        friend.put('F', 2);
        friend.put('J', 3);
        friend.put('M', 4);
        friend.put('N', 5);
        friend.put('R', 6);
        friend.put('T', 7);

        answer = 0;
        list = new int[8]; // 알파벳이 들어갈 위치
        isVisited = new boolean[8];
        perm(0);

        return answer;
    }

    private static void perm(int cnt) {
        if (cnt == 8) {
            if (isCorrect())
                answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (isVisited[i])
                continue;

            isVisited[i] = true;
            list[cnt] = i;
            perm(cnt + 1);
            isVisited[i] = false;
        }
    }

    private static boolean isCorrect() {
        for (String s : s_data) {
            int friend1 = list[friend.get(s.charAt(0))];
            int friend2 = list[friend.get(s.charAt(2))];
            char op = s.charAt(3);
            int d = s.charAt(4) - '0' + 1;

            int distance = Math.abs(friend1 - friend2);
            if (op == '=') {
                if (distance != d)
                    return false;
            } else if (op == '>' ) {
                if(distance <= d)
                    return false;
            } else if (distance >= d)
                return false;
        }

        return true;
    }
}