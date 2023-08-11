package UBiiiii.Week7.lv2.소수찾기;

class Solution {
    static int[] cnt, tmpCnt;
    static boolean[] isChecked;
    public int solution(String numbers) {
        int answer = 0;
        cnt = new int[10];
        /*
         * numbers와 같은 자리수의 모든 수를 확인할 수 있도록 isChecked의 크기를 설정
         * cnt에 numbers의 각 자리 수의 개수를 저장
         * 2부터 isChecked의 마지막까지, 각 수에 대하여 확인
         */
        isChecked = new boolean[(int) Math.pow(10, numbers.length()) + 1];
        isChecked[0] = isChecked[1] = true;
        for(int i=0;i<numbers.length();i++) cnt[numbers.charAt(i)-'0']++;
        for(int i=2;i< (int) Math.pow(10, numbers.length()); i++)   answer += check(i) ? 1 : 0;
        
        return answer;
    }
    
    /*
     * 해당 수가 원하는 수인지 확인하는 함수
     * 1. 현재 입력된 num에 대하여 isChecked[num] = true -> 약수가 있으므로 return false;
     * 2. 입력된 수의 배수들에 대하여 isChecked[i] = true -> 이후에 나오는 수가 소수가 아님을 검사하는 목적
     * 3. num의 각 자리 수의 갯수를 확인 -> 문제에서 입력한 numbers의 개수보다 많을 경우 return false;
     */
    private static boolean check(int num) {
        if(isChecked[num])  return false;
        for(int i=num;i<isChecked.length;i+=num)    isChecked[i] = true;
        
        String curr = Integer.toString(num);
        tmpCnt = new int[10];
        
        for(int i=0;i<curr.length();i++) tmpCnt[curr.charAt(i)-'0']++;
        for(int i=0;i<10;i++)   if(cnt[i]<tmpCnt[i])    return false;
        return true;
    }

}