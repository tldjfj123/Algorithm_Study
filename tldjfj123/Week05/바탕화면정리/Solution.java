package 바탕화면정리;

class Solution {
    public int[] solution(String[] wallpaper) {
        int min_x = wallpaper[0].length();
        int min_y = wallpaper.length;
        int max_x = 0;
        int max_y = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                int curr_x = j;
                int curr_y = i;

                if (wallpaper[i].charAt(j) == '#') {
                    if (min_x > curr_x) {
                        min_x = curr_x;
                    }
                    if (min_y > curr_y) {
                        min_y = curr_y;
                    }
                    if (max_x < curr_x) {
                        max_x = curr_x;
                    }
                    if (max_y < curr_y) {
                        max_y = curr_y;
                    }
                }
            }
        }

        int[] answer = {min_y, min_x, max_y + 1, max_x + 1};
        return answer;
    }
}