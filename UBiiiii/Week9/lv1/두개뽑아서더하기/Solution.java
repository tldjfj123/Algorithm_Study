package UBiiiii.Week9.lv1.두개뽑아서더하기;

import java.util.*;

class Solution {
    public Integer[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<numbers.length-1;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        for(int n : set) {
            arr.add(n);
        }
        
        return arr.stream().sorted((a,b)->a-b).toArray(Integer[]::new);
    }
}