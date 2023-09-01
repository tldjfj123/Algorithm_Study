package YeonChanLim.Week10.땅따먹기;

/*
DP 하하하하하ㅏㅎ
정리를 한번 샤그닥 해야겠다...

i번째 행에서 열이 선택되었을때
i-1번째 행 중 선택된 열을 제외한 나머지들 중 최대값을 구해서 더하는 형태
참고 사이트 : https://ilmiodiario.tistory.com/88
 */

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i ++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}
