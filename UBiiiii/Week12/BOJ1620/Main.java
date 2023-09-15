package UBiiiii.Week12.BOJ1620;

/*
 * 나는야 포켓몬 마스터 이다솜
 * 주요 풀이 : 겁나 긴 문제를 읽지 않는 것. 다 부질없고 예제 입력 보는 게 도움이 된다.
 * 도감이니까 결국 Map으로 풀어야겠다는 결론 -> 인덱스 : 이름 으로 저장하자
 * 입력에 인덱스도 있다 -> 이름 : 인덱스 로 저장하는 Map을 하나 더 만들자
 * 도감 다 저장하고 나면 입력에 따라서(숫자, 문자) 각각의 Map에서 출력해서 보여주자
 * 1. Java에도 isDigit가 있다! 다만 캐릭터 한정이고, 스트링 전체에 대해서는 없는 거 같다. 이거 해주면 파이썬이지
 * 2. 두 개 다 Map으로 하는 것과, 하나는 배열로 하는 것 중에 어떤 게 더 빨랐을까?
 * 3. 알고리즘 분류가 자료 구조라는 건 또 대체 뭘까...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> pokemon = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++) {
            input = br.readLine();
            pokemon.put(i, input);
            index.put(input, i);
        }

        for(int i=0;i<m;i++) {
            input = br.readLine();

            if(Character.isDigit(input.charAt(0))) sb.append(pokemon.get(Integer.parseInt(input)));
            else                          sb.append(index.get(input));

            if(i!=m-1)  sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
