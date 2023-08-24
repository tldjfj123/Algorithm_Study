package 타겟넘버;

class Solution {
    static int result = 0; // 편의를 위해 static 선언

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return result;

    }

    public void dfs(int[] numbers, int target, int idx, int sum) { // dfs를 통한 완전탐색
        if (idx == numbers.length) { // 재귀 탈출 조건 : 배열 내 모든 원소 덧셈 / 뺄셈을 완료했을 떄
            if (sum == target) {
                result++;
            }
            return;
        }
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}