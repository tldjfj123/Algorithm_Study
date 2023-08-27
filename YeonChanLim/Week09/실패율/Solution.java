package YeonChanLim.Week09.실패율;

/*
도전자와 실패자를 구하고 이걸 토대로 실패율을 구해서 실패율 순으로 정렬하고 반환해야겠다는 생각
1. 각 스테이지에 머무르고 있는 사람 수
2. 각 스테이지를 플레이한 사람 수
    - 스테이지 4에 머문다면 1~4 스테이지 시도, 4 스테이지 실패율 반영
    - N + 1 스테이지일 경우 모든 스테이지 시도
3. 각 스테이지 머무르고 있는 사람 / 각 스테이지 플레이한 사람 * 100 ===> 실패율
참고 사이트 : https://blog.itcode.dev/posts/2021/12/15/programmers-a0018
 */

import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] fails = new int[N];
        int[] users = new int[N];

        // 시도자, 실패자 카운트
        for (int stage : stages)
        {
            // 마지막 스테이지를 깨지 않았을 경우
            if (stage != N + 1)
            {
                // 실패한 유저 카운트
                fails[stage - 1]++;

                // 시도한 유저 카운트
                for (int i = 0; i < stage; i++)
                {
                    users[i]++;
                }
            }
            // 마지막 스테이지를 깼을 경우
            else
            {
                // 시도한 유저 전부 카운트
                for (int i = 0; i < users.length; i++)
                {
                    users[i]++;
                }
            }
        }
        // ==================== 이 아래쪽은 구글 참고.. ====================
        // 실패율
        ArrayList<Double[]> failRate = new ArrayList<>();
        // 실패율에 인덱스와 값 할당
        for (int i = 0; i < N; i++)
        {
            // 시도자, 실패자가 아무도 없을 경우 0을 나누게 되므로 NaN 처리 필요
            double rate = Double.isNaN((double) fails[i] / users[i]) ? 0 : (double) fails[i] / users[i];
            failRate.add(new Double[] { (double) i + 1, rate });
        }
        // 정렬
        failRate.sort((o1, o2) -> Double.compare(o2[1], o1[1]));
        return failRate.stream().mapToInt(value -> value[0].intValue()).toArray();
    }
}
