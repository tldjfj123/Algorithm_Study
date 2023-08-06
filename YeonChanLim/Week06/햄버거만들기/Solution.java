package YeonChanLim.Week06.햄버거만들기;

class Solution {
    public int solution(int[] ingredient) {

        int[] newIngredient = new int[ingredient.length]; //기존 배열 복사본 newIngredient 배열 생성
        int idx = 0, answer = 0; //초기화

        for(int ing : ingredient) {
            newIngredient[idx] = ing; //ingredient 배열 요소들을 newIngredient 배열에 순차적으로 복사
            idx++;

            if(idx >= 4) { // idx가 4 이상일때 1,2,3,1 패턴을 찾기 위해 조건문 실행
                if(newIngredient[idx-4] == 1 &&
                        newIngredient[idx-3] == 2 &&
                        newIngredient[idx-2] == 3 &&
                        newIngredient[idx-1] == 1) {
                    idx -= 4; // 해당되는걸 찾았을때 요소를 건너뛰기 위해 4를 뺴줌

                    answer++; // 그리고 answer 1 증가
                }
            }
        }
        return answer;
    }
}
