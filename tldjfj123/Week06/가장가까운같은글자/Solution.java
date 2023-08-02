package 가장가까운같은글자;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            //If key value doesn't exist, append current idx at HashMap and append -1 at result array
            if (!map.containsKey(String.valueOf(s.charAt(i)))) {
                map.put(String.valueOf(s.charAt(i)), i);
                result.add(-1);
            }
            //If key value exist, update HashMap by current idx and append value of gap between current idx and saved idx at result array
            else {
                int tmp = i - map.get(String.valueOf(s.charAt(i)));
                result.add(tmp);
                map.put(String.valueOf(s.charAt(i)), i);
            }

        }

        //Convert ArrayList to Array

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}