package BOJ1107;

/*
 * 리모컨이 고장났으면 좀 바꾸자이씨
 * 
 * 첫 번째 방식 : 현 위치에서 +1, -1을 해서, 만들 수 있는 숫자인지 확인하는 방식을 사용하자.
 * -> 시간 초과. String으로 변환하고 각 숫자마다 broken에 포함되었는지 확인하는 과정이 시간이 오래 걸리나보다
 * 
 * 두 번째 방식 : 부서지지 않은 버튼을 이용해서 최소 숫자로부터 최대 숫자까지 만들어서 일일이 확인하자.
 * -> 자릿수를 입력과 동일하게 했을 때, 한 자리 위에서 오는 경우도 있을 수 있으므로 한 자리 위에서 시작하는 케이스 추가
 * -> 앞자리부터 수를 선택해서 더하는 dfs를 이용하자. 현재까지 더한 수가 0일 경우에는 현재 자리에도 0을 쓸 수 있게 해서 낮은 자리 수도 쓸 수 있게 하자
 * -> 위 조건만 추가하니까 0이 무조건 추가되므로, 마지막 자리수에는 위 조건이 적용되지 않도록 수정
 * -> 현재 채널(100)에서 목표 채널까지 방향키로 이동하는 값과, 채널 이동 후 방향키로 이동하는 값 중 최소값을 출력하자
 */

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