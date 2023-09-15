package UBiiiii.Week12.BOJ1620;

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
