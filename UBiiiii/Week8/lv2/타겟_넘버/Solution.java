package UBiiiii.Week8.lv2.타겟_넘버;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }
    
    private int dfs(int[] numbers, int sum, int target, int idx) {
        if(idx == numbers.length)   return sum==target ? 1 : 0;
        
        return dfs(numbers, sum+numbers[idx], target, idx+1)
            + dfs(numbers, sum-numbers[idx], target, idx+1);
        
    }
}