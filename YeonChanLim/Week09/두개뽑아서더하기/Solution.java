package YeonChanLim.Week09.두개뽑아서더하기;

/*
반복문 돌리면서 합 구하고 중복되지 않는 값들 뽑으면 될거 같다고 생각했음
그래서 처음에 중복처리를 위한 ArrayList 만들어주고,
2중 for문으로 두 수의 합 구하고,
contains()써서 포함이 되어 있는지 아닌지 체크해주고 ,
리스트에 담긴 값을 answer배열에 담아줌!
오름차순 정렬 해야되니까 Arrays.sort()로 정렬 샤그닥

 */

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            int sum = 0;

            // 반복문이 0부터 돌면 똑같은 값 계속 구해서 +1로 계산
            for(int j = i + 1; j < numbers.length; j++){
                sum = numbers[i] + numbers[j];

                if(!list.contains(sum)){
                    list.add(sum);
                }
            }
        }

        int[] answer = new int[list.size()];

        //리스트에 있는 값들 넣기
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
