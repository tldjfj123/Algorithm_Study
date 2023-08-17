package YeonChanLim.Week08.숫자문자열과영단어;

class Solution {
    public int solution(String s) {

        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i = 0; i < arr.length; i++){
            if(s.contains(arr[i])){
                s = s.replace(arr[i], Integer.toString(i));
            }
        }
        int answer = Integer.parseInt(s);

        return answer;
    }
}
