package 두개뽑아서더하기;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }

        int[] answer = new int[set.size()];
        int idx = 0;
        for (int s : set) {
            answer[idx++] = s;
        }

        Arrays.sort(answer);

        return answer;
    }
}