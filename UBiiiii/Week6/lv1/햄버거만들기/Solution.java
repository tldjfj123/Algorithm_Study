package 햄버거만들기;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i : ingredient) {
            sb.append(i);
            // 문자열을 쌓으면서 햄버거("1231")가 될 때마다 "1231" 삭제 및 answer++
            if(sb.length()>=4 && sb.substring(sb.length()-4).equals("1231")) {
                answer++;
                sb.delete(sb.length()-4, sb.length());
            }
        }
        
        return answer;
    }
}