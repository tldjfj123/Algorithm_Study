package YeonChanLim.Week10.다음큰숫자;

/*
처음에 한 생각은
입력된 n을 2진수로 바꿔주고 -> 2진수의 비트가 1인 개수 세고 -> n+1부터 반복하면서 일치하는거 찾기
2진수로 바꿔야 하니까 toBinaryString 사용

String binaryString = Integer.toBinaryString(i); //2진수
String octalString = Integer.toOctalString(i);   //8진수
String hexString = Integer.toHexString(i);       //16진수

일단 이렇게 하고 나서 구글링 해보니까 기똥찬 코드 발견
- 코드는 밑에 주석 달아놓을게요
참고 사이트 : https://sas-study.tistory.com/261

자바의 Integer 클래스에 bitCount(int i) 라는 메소드
integer형 타입의 숫자 데이터의 비트데이터(2진데이터이며 binary데이터)중 1 비트의 수를 카운트해주는 메소드
 */

class Solution {
    public int solution(int n) {

        int answer = 0;
        // 입력된 정수를 이진수 문자열로 변환
        String str = Integer.toBinaryString(n);

        // 입력된 이진수에서 '1'의 개수를 세는 변수
        int cnt =0;

        // 입력된 이진수 문자열에서 '1'의 개수를 세는 반복문
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '1') cnt++;
        }

        // n보다 큰 수 중에서 '1'의 개수가 같은 수를 찾는 반복문
        for(int i =n+1;i<1000000;i++){

            String temp = Integer.toBinaryString(i);
            int temp_cnt = 0;
            for(int j =0;j<temp.length();j++){
                if(temp.charAt(j) == '1') temp_cnt++;
            }

            if(temp_cnt == cnt) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}

/*
class Solution {
  public int solution(int n) {
      int bitCount = Integer.bitCount(n);
        for(int i = n+1; ;i++) {
            if(bitCount == Integer.bitCount(i)) {
                return i;
            }
        }
  }
}
 */
