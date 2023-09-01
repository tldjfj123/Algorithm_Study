package 땅따먹기;

/**
 * dfs -> 시간복잡도 터짐 --> dp 문제구나
 */


class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) { // row
            for (int j = 0; j < 4; j++) { // column
                int tmp = 0; // 최댓값 구하기 위함
                // 전 row에서 동일 위치 제외한 최댓값 탐색
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        tmp = Math.max(land[i-1][k], tmp);
                    }
                }

                land[i][j] += tmp;
            }
        }

        int result = 0;
        for (int i = 0; i < land[land.length-1].length; i++) {
            result = Math.max(land[land.length-1][i], result);
        }

        return result;
    }
}