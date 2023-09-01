package 가장큰정사각형찾기;

/**
 * 탐색만으로는 정사각형 보장 불가
 * -> 우측 하단을 기준으로 왼쪽. 위쪽, 좌상단이 1인 모두 1인 경우 정사각형이 보장된다!! 결국 dp노 ㅅㅂ;;;
 */

class Solution
{
    public int solution(int [][]board)
    {
        int row = board.length;
        int column = board[0].length;

        //배열 크기가 2 by 2 가 안되는 경우
        if (row == 1 && column == 1) {
            if (board[0][0] == 1) {
                return 1;
            } else {
                return 0;
            }
        }


        // 배열 갖고 놀아야해서 원본 유지한채로 복사
        int[][] tmp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tmp[i][j] = board[i][j];
            }
        }

        //System.out.println("tmp = " + Arrays.deepToString(tmp));
        int max = 0;
        for (int i = 1; i < tmp.length; i++) {
            for (int j = 1; j < tmp[0].length; j++) {
                if (tmp[i][j] != 0) {
                    int value = Math.min(Math.min(tmp[i-1][j], tmp[i][j-1]) , tmp[i-1][j-1]); // 탐색기준따라 탐색 후, 한개라도 0이면 0 더해짐
                    tmp[i][j] = value + 1;

                    max = Math.max(tmp[i][j], max);
                }
            }
        }

        return max * max;
    }
}