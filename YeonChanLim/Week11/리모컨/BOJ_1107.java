package YeonChanLim.Week11.리모컨;

/*
우선 이 문제는 너무 빡셌습니다. ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
참고 사이트 : https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-1107-%EB%A6%AC%EB%AA%A8%EC%BB%A8-Java%EC%9E%90%EB%B0%94

고장난 숫자버튼 담아두기 위한 broken배열
고장난 번호는 true로
입력 받을 수 있는 채널 최댓값이 500000,  숫자로 가능한 최댓값 999999까지 반복
i값이 이동할 채널의 번호를 의미
i를 숫자로 이동하는 과정에서 고장난 번호가 있다면 확인해 볼 필요가 없기 때문에 다음 반복으로
고장난 번호가 없는 i값의 경우, i 채널로 이동할 때 누른 횟수인 len값과, +-를 눌러 이동하게 될 잔여 횟수를 더해 answer과 비교
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean [] broken = new boolean[10];

        if(n > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; ++i) broken[Integer.parseInt(st.nextToken())] = true;
        }
        int answer = Math.abs(channel-100);

        next : for(int i = 0; i < 1000000; ++i)
        {
            String cur = i+"";
            int len = cur.length();

            for(int j = 0; j < len; ++j)
            {
                if(broken[cur.charAt(j)-'0']) continue next;
            }
            answer = Math.min(answer,len + Math.abs(channel-i));
        }

        System.out.print(answer);
    }
}
