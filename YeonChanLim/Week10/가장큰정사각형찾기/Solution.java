package YeonChanLim.Week10.가장큰정사각형찾기;

/*
for문 돌아서 위치값[i][j]dl 0이 아니면
자신의 기준으로 왼쪽상단(↖), 왼쪽(←), 위쪽(↑) 의 최솟값 구하고
자신의 위치에 최솟값+1을 할당
참고 사이트 : https://small-stap.tistory.com/40
https://hu-coding.tistory.com/136
 */

class Solution{
    public int solution(int [][]board){
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        // board의 행 또는 열이 1로 주어질 때 예외처리
        if(row < 2 || col < 2){
            return 1;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(board[i][j] !=0){
                    // board[i][j]의 왼쪽 상단, 왼쪽, 위쪽 중 최솟값 구해서 +1 후 할당
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]))+1;
                }
                // 그 중 최댓값을 answer에 할당
                if(answer < board[i][j]) answer = board[i][j];
            }
        }

        return answer * answer; // 정사각형 넓이
    }
}
