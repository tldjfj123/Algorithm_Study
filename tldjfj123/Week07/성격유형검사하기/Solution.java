package 성격유형검사하기;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //RCJA
        int[] table1 = new int[4];
        //TFMN
        int[] table2 = new int[4];

        //"RT", "CF", "JM", "AN"

        for (int i = 0; i < survey.length; i++) {
            String keyword = survey[i];
            int score = choices[i];

            if (keyword.equals("RT")) {
                if (score < 4) {
                    table1[0] += (4 - score);
                } else {
                    table2[0] += (score - 4);
                }
            } else if (keyword.equals("TR")) {
                if (score > 4) {
                    table1[0] += (score - 4);
                } else {
                    table2[0] += (4 - score);
                }
            } else if (keyword.equals("CF")) {
                if (score < 4) {
                    table1[1] += (4 - score);
                } else {
                    table2[1] += (score - 4);
                }
            } else if (keyword.equals("FC")) {
                if (score > 4) {
                    table1[1] += (score - 4);
                } else {
                    table2[1] += (4 - score);
                }
            } else if (keyword.equals("JM")) {
                if (score < 4) {
                    table1[2] += (4 - score);
                } else {
                    table2[2] += (score - 4);
                }
            } else if (keyword.equals("MJ")) {
                if (score > 4) {
                    table1[2] += (score - 4);
                } else {
                    table2[2] += (4 - score);
                }
            } else if (keyword.equals("AN")) {
                if (score < 4) {
                    table1[3] += (4 - score);
                } else {
                    table2[3] += (score - 4);
                }
            } else {
                if (score > 4) {
                    table1[3] += (score - 4);
                } else {
                    table2[3] += (4 - score);
                }
            }
        }

        String res = "";

        if (table1[0] >= table2[0]) {
            res += "R";
        } else {
            res += "T";
        }

        if (table1[1] >= table2[1]) {
            res += "C";
        } else {
            res += "F";
        }

        if (table1[2] >= table2[2]) {
            res += "J";
        } else {
            res += "M";
        }

        if (table1[3] >= table2[3]) {
            res += "A";
        } else {
            res += "N";
        }


        return res;

    }
}