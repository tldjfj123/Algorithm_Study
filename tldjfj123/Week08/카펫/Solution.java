package 카펫;

class Solution {

    /**
     * 갈색 개수 구하는 공식 : row * 2 + (column + 2) * 2
     * 노랑이 갯수로 갈색 갯수를 구하여 전체가 몇 by 몇인지 유추
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int row = 1; row <= yellow; row++) {
            if (yellow % row == 0) {
                int column = yellow / row;
                int calc = (row * 2) + ((column + 2) * 2);

                if (calc == brown) {
                    answer[0] = column + 2;
                    answer[1] = row + 2;
                    break;
                }
            }
        }

        return answer;
    }
}