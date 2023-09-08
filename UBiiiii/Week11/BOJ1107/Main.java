package BOJ1107;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int answer = 1_000_000, cnt, n, m, gap;
    private static String input;
    private static List<Integer> broken = new ArrayList<>();
    private static Integer[] btn = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        n = Integer.parseInt(input);
        m = Math.abs(n-100);
        cnt = Integer.parseInt(br.readLine());
        
        if(cnt==0) {
            System.out.println(Math.min(m, input.length()));
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<cnt;i++)  broken.add(Integer.parseInt(st.nextToken()));

        dfs(input.length(), 0);

        System.out.println(Math.min(Math.abs(n-100), answer));
    }

    private static void dfs(int idx, int curr) {
        if(idx==-1) {
            gap = Math.abs(curr-n);
            if(answer > gap + Integer.toString(curr).length())  {
                answer = gap + Integer.toString(curr).length();
            }
            return;
        }

        if(idx==input.length()) {
            dfs(idx-1, curr);
            if(!broken.contains(1)&&input.charAt(0)>'4') dfs(idx-1, curr+(int)Math.pow(10, idx));
        } else {
            Set<Integer> cbtn = Arrays.stream(btn).filter(el->!broken.contains(el)).collect(Collectors.toSet());
            if(curr==0 && idx!=0) cbtn.add(0);
            for(int i : cbtn) {
                dfs(idx-1, curr+i*(int)Math.pow(10, idx));
            }
        }
    }
}