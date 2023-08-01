package 공원산책;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int max_x = park[0].length();
        int max_y = park.length;
        int start_x = 0;
        int start_y = 0;

        //시작지점 찾기
        for (int i = 0; i < max_y; i++) {
            if (park[i].contains("S")) {
                start_y = i;
                start_x = park[i].indexOf("S");
            }
        }

        //경로 탐색
        for (String route : routes) {
            String order = route.split(" ")[0];
            int range = Integer.parseInt(route.split(" ")[1]);

            int tmp_x = start_x;
            int tmp_y = start_y;

            if(order.equals("E")){
                boolean flag = false;
                for (int i = 1; i <= range; i++){
                    tmp_x++;
                    if(tmp_x >= max_x){
                        flag = true;
                        break;
                    }
                    // 장애물이 있나
                    else if(park[tmp_y].charAt(tmp_x) =='X'){
                        flag = true;
                        break;
                    }

                }
                if (!flag) {
                    start_x = tmp_x;
                }
            }
            else if(order.equals("W")){
                boolean flag = false;
                for(int i = 1; i <= range; i++){
                    tmp_x--;
                    if(tmp_x < 0){
                        flag = true;
                        break;
                    }
                    else if(park[tmp_y].charAt(tmp_x) =='X'){
                        flag = true;
                        break;
                    }

                }
                if (!flag) {
                    start_x = tmp_x;
                }
            }
            else if(order.equals("S")){
                boolean flag = false;
                for(int i = 1; i <= range; i++){
                    tmp_y++;
                    if(tmp_y >= max_y){
                        flag = true;
                        break;
                    }
                    else if(park[tmp_y].charAt(tmp_x) =='X'){
                        flag = true;
                        break;
                    }

                }
                if (!flag) {
                    start_y = tmp_y;
                }
            }
            else if(order.equals("N")){
                boolean flag = false;
                for(int i = 1;i <= range; i++){
                    tmp_y--;
                    if(tmp_y < 0){
                        flag = true;
                        break;
                    }
                    else if(park[tmp_y].charAt(tmp_x) =='X'){
                        flag = true;
                        break;
                    }

                }
                if (!flag) {
                    start_y = tmp_y;
                }
            }

        }

        int[] answer = {start_y, start_x};
        return answer;
    }
}