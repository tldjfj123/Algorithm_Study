package YeonChanLim.Week09.단체사진찍기;

/*
참고 사이트 : https://today-retrospect.tistory.com/345
DFS 문제인건 생각 했는데 직접 짜려고 하면 너무 어렵다..

매서드
1. Solution
 - visited 배열은 각 문자가 이미 위치에 사용되었는지 여부를 저장
 - dfs 메서드를 호출하여 문제를 해결하고, answer 반환
2. DFS
 - 깊이 우선 탐색을 통해 모든 가능한 위치 조합을 탐색
 - idx가 8이 되면 모든 위치가 결정되었다는 의미이므로,
   check 메서드를 통해 조건을 만족하는지 검사하고,
   조건을 만족하면 answer 증가
 - 각 위치에 대해 모든 친구의 위치를 시도하면서 재귀 호출을 수행
3. Check
 - 주어진 위치 조합이 제약 조건을 만족하는지 검사
 - 각 조건마다, 해당 조건에 대한 검사를 수행
 */

class Solution {
    static int answer;
    static boolean[] visited;
    static String[] arr = {"A","C","F","J","M","N","R","T"};

    public static int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[8];

        dfs(0," ",data);
        return answer;
    }

    private static void dfs(int idx, String names,String[] data){ // idx = 현재 위치, names는 현재까지 결정된 위치 문자열, data = 친구 간의 제약 조건을 나타내는 배열
        // 모든 문자열에 대한 위치가 결정되었을 때
        if(idx == 8){
            // 조건을 만족하면 경우의 수 증가
            if(check(names,data)) {
                answer += 1;
            }
            return;
        }

        for(int i = 0; i< 8; i++){
            if(!visited[i]){
                visited[i] = true;
                // 새로운 문자열 생성
                String name = names + arr[i];
                // 다음 위치 결정을 위해 재귀 호출
                dfs(idx + 1,name,data);
                // 다른 경우를 위해 현재 문자의 위치 사용 해제
                visited[i] = false;
            }
        }
    }

    private static boolean check(String name,String[] data){ // name = 현재 위치 문자열, data = 친구 간의 제액조건
        for(String str : data){

            // 조건에 있는 두 친구 위치 찾아냄
            int pos1 = name.indexOf(str.charAt(0));
            int pos2 = name.indexOf(str.charAt(2));

            char logic = str.charAt(3);
            int standard = str.charAt(4) - '0';

            switch (logic){
                case '=' :
                    if(!(Math.abs(pos1 - pos2) == standard + 1)){
                        return false;
                    }
                    break;
                case '>' :
                    if(!(Math.abs(pos1 - pos2) > standard + 1)){
                        return false;
                    }
                    break;
                case '<' :
                    if(!(Math.abs(pos1 - pos2) < standard + 1)){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
