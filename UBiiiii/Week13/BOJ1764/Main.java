package BOJ1764;

/*
 * 듣보잡
 * 쉬운 문제니까 지나가자
 * 두 집단에 중복되는 사람을 찾아서 출력 -> Map으로 해서 처리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Boolean> people = new HashMap<>();
        List<String> answer = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++)    people.put(br.readLine(), false);
        for(int i=0;i<m;i++) {
            String input = br.readLine();
            if(people.containsKey(input))   people.put(input, true);
        }

        for(String key : people.keySet()) if(people.get(key)) answer.add(key);

        Collections.sort(answer);

        System.out.println(answer.size());
        for(String a : answer)  System.out.println(a);
    }
}
