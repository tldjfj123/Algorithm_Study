package 과일장수;

import java.util.*;

class Solution {
    //m : maximum storage of box
    public int solution(int k, int m, int[] score) {
        //Convert score's element to Integer for using sort method by descending
        Integer[] arr = new Integer[score.length];

        for (int i = 0; i < score.length; i++) {
            arr[i] = score[i];
        }

        //Sort array by descending
        Arrays.sort(arr, Collections.reverseOrder());

        int res = 0;

        // Add min value of boxes that can be constructed
        // Calculation : min * m
        if (arr.length % m == 0) {
            for (int i = 0; i < arr.length; i += m) {
                res += arr[i + m - 1] * m;
            }
        } else {
            for (int i = 0; i < arr.length - m; i += m) {
                res += arr[i + m - 1] * m;
            }
        }

        return res;
    }
}