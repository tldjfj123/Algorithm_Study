package YeonChanLim.Week05.공원산책;

import java.util.*;

public class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = -1;
        int y = -1;
        int height = park.length;
        int weight = park[0].length();

        for(int i=0;i<park.length;i++){
            if(park[i].indexOf('S') != -1){
                x = park[i].indexOf('S');
                y = i;
                break;
            }
        }

        for(int i=0;i<routes.length;i++){
            String[] temp = routes[i].split(" ");
            String vector = temp[0];
            int distance =  Integer.parseInt(temp[1]);
            int currX = x;
            int currY = y;

            if(vector.equals("E")){
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currX++;
                    if(currX >= weight){
                        flag = false;
                        break;
                    }

                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    x = currX;
                }
            }
            else if(vector.equals("W")){
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currX--;
                    if(currX < 0){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    x = currX;
                }
            }
            else if(vector.equals("S")){
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currY++;
                    if(currY >= height){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    y = currY;
                }
            }
            else if(vector.equals("N")){
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currY--;
                    if(currY < 0){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    y = currY;
                }
            }

        }

        answer[0] = y;
        answer[1] = x;

        return answer;
    }
}

