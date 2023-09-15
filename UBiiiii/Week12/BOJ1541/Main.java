package UBiiiii.Week12.BOJ1541;

/*
 * 잃어버린 괄호
 * 주요 풀이 : 플러스는 모르겠고 마이너스를 하자
 * 예전에 그래프 탐색 순서 관련해서 전위 탐색, 중위 탐색, 후위 탐색 뭐 이런 거 할 때 비슷한 걸 본 거 같은데, 그건 차치하고
 * 문제의 목적은 최솟값을 출력하는 것 -> '-' 뒤에 오는 값이 커져야된다는 거죠? -> '+' 계산 먼저 하고 '-'를 나중에 하면 되겠당
 * 입력으로 들어온 문자열을 기호와 숫자로 분리(정규식 최고당)
 * 기호 배열에서 먼저 "+"인 경우를 찾아, 인덱스를 이용해서 해당 값을 더해서 자리에 넣고, 더할 때 사용한 값은 제거("+" 기호도 제거)
 * 나머지 수는 최초값을 제외하고는 빼기 연산을 해서 출력하자
 * 1. 정규식은 최고다. 정규식도 더 공부해보자. 프론트는 특히 쓸 곳이 많을 거 같다(아이디에 특수기호, 대문자, 소문자, 숫자 집어넣는 거 같은걸로)
 * 2. 알고리즘 분류가 그리디다. 그리디도 사실 뭔지 모르겠다. 그냥 정해진 공식 없이 최적으로 찾는 게 그리디인 건가?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int idx, tmp, answer = 0;
        List<Integer> nums = new ArrayList<>(Arrays.stream(input.split("[+-]")).map(el->Integer.parseInt(el)).collect(Collectors.toList()));
        List<String> symbol = new ArrayList<>(Arrays.stream(input.split("[^+-]")).filter(el->el.length()!=0).collect(Collectors.toList()));
        while(symbol.contains("+")) {
            idx = symbol.indexOf("+");
            tmp = nums.get(idx) + nums.get(idx+1);
            nums.remove(idx);
            nums.set(idx, tmp);
            symbol.remove(idx);
        }
        answer = nums.get(0);
        for(int i=1;i<nums.size();i++) answer -= nums.get(i);
        System.out.println(answer);
    }
}