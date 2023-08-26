package YeonChanLim.Week09.키패드누르기;

/*
1, 4, 7, * -> 왼쪽
2, 5, 8, 0 -> 중간
3, 6, 9, # -> 오른쪽 으로 묶고
*, 0, #은 각각 10, 11, 12로 대입해서 숫자로 가지고 놀자고 생각
그런 다음에 아래 주석 단 부분을 작성했는데 중간값은 어캐 해야 될지
잘 모르겠어서 구글링..(참고 사이트 : https://dding9code.tistory.com/75)
키패드는 세로는 3개 가로도 3개 이기 때문에
'현재 위치 - 누르는 위치의 절대값' 을 한 결과를 위 아래로 움직일 때는 '/3 ' 을 해주고,
좌 우 로 움직이는 거리는 '%3' 이니 두개값을 더하면 거리를 구할 수 있음

그리고 하나 더 배워가는거.. Math.abs
결과값이 음수여도 절대값만을 반환함..!
이론 책에서만 보다가 실제로 사용하는건 처음인거 같군.....흠
 */

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        /*
        int left = 10;
        int right = 12;

        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                left = num;
            } else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                right = num;
            } else {
                if(num == 0){
                    num += 11;
                }

            }
        }
        */
        int left = 10;
        int right = 12;

        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                left = num;
            } else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                right = num;
            } else {
                if(num == 0){
                    num += 11;
                }

                int leftDiff = (Math.abs(num - left) / 3) +(Math.abs(num - left) % 3);
                int rightDiff = (Math.abs(num - right) / 3) +(Math.abs(num - right) % 3);

                if(leftDiff > rightDiff){
                    answer += "R";
                    right = num;
                } else if(leftDiff < rightDiff){
                    answer += "L";
                    left = num;
                } else {
                    if(hand.equals("left")){
                        answer += "L";
                        left = num;
                    } else {
                        answer += "R";
                        right = num;
                    }
                }
            }
        }
        return answer;
    }
}
