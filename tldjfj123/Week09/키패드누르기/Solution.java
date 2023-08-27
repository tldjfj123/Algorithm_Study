package 키패드누르기;



/**
 * 	"LRLLLRLLLRL"
 * 	"LRLLLRLLRRL".
 * 	ㅅㅂ 위치를 어떻게 표현해야할지 도저히 감이 안옴 ( 1트꺼) -> 응 왔어~
 *
 * 	   /**
 *         //contains 메소드 사용위해 List로 선언
 *         List<Integer> left = Arrays.asList(1, 4, 7);
 *         List<Integer> center = Arrays.asList(2, 5, 8, 0);
 *         List<Integer> right = Arrays.asList(3, 6, 9);
 *
 *         String result = "";
 *
 *         int leftIdx = -1;
 *         int rightIdx = -1;
 *
 *         for (int i = 0; i < numbers.length; i++) {
 *             if (left.contains(numbers[i])) {
 *                 result += "L";
 *                 leftIdx = left.indexOf(numbers[i]);
 *             } else if (right.contains(numbers[i])) {
 *                 result += "R";
 *                 rightIdx = right.indexOf(numbers[i]);
 *             } else {
 *                 int centerIdx = center.indexOf(numbers[i]);
 *                 if (Math.abs(leftIdx - centerIdx) > Math.abs(rightIdx - centerIdx)) { //왼쪽이 더 크다 = 더 멀다 = 답은 오른쪽
 *                     result += "R";
 *                     rightIdx = right.indexOf(numbers[i])-1;
 *                 } else if (Math.abs(leftIdx - centerIdx) < Math.abs(rightIdx - centerIdx)) {
 *                     result += "L";
 *                     leftIdx = left.indexOf(numbers[i])-1;
 *                 } else {
 *                     if (hand.equals("left")) {
 *                         result += "L";
 *                         leftIdx = left.indexOf(numbers[i])-1;
 *                     }
 *                     else {
 *                         result += "R";
 *                         rightIdx = right.indexOf(numbers[i])-1;
 *                     }
 *                 }
 *             }
 *         }
 *
 *         return result;
 *      }
 *
 */

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        // 좌표값 계산하기 ㅈ같아서 걍 때려박고 시작
        // 1, 4, 7 : 왼손 사용
        // 3, 6, 9 : 오른손 사용

        Map<Integer, Integer[]> map = new HashMap<>();
        map.put(1, new Integer[]{0, 0});
        map.put(2, new Integer[]{0, 1});
        map.put(3, new Integer[]{0, 2});
        map.put(4, new Integer[]{1, 0});
        map.put(5, new Integer[]{1, 1});
        map.put(6, new Integer[]{1, 2});
        map.put(7, new Integer[]{2, 0});
        map.put(8, new Integer[]{2, 1});
        map.put(9, new Integer[]{2, 2});
        map.put(0, new Integer[]{3, 1});

        Integer[] leftIdx = {3, 0};
        Integer[] rightIdx = {3, 2};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            Integer[] target = map.get(value);

            if (value == 1 || value == 4 || value == 7) {
                sb.append("L");
                leftIdx = target;
            } else if (value == 3 || value == 6 || value == 9) {
                sb.append("R");
                rightIdx = target;
            } else {
                int leftDistance = calcDistance(leftIdx, target);
                int rightDistance = calcDistance(rightIdx, target);

                if (leftDistance > rightDistance) { // 오른쪽이 답
                    sb.append("R");
                    rightIdx = target;
                } else if (leftDistance < rightDistance) { // 왼쪽이 답
                    sb.append("L");
                    leftIdx = target;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightIdx = target;
                    } else {
                        sb.append("L");
                        leftIdx = target;
                    }
                }
            }

        }

        return sb.toString();

        }
    public static int calcDistance(Integer[] point1, Integer[] point2) { // 맨해튼 거리
        int xDiff = Math.abs(point2[0] - point1[0]);
        int yDiff = Math.abs(point2[1] - point1[1]);

        // 맨해튼 거리 계산
        int distance = xDiff + yDiff;

        return distance;
    }


}