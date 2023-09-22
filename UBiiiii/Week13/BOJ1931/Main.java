package BOJ1931;

/*
 * 회의실 배정
 * 조건부 정렬
 * 사실 아직도 왜 종료시간 기준으로 정렬하면 답이 나오는지 모르겠다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	static int n, answer = -1;
	static int[][] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		input = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
			
		Arrays.sort(input, (a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1] - b[1]);
		
		int[] pre = new int[] {-1, -1};
		answer = 0;
		
		for(int i=0;i<n;i++) {
			int tmp[] = input[i];
			if(tmp[0] >= pre[1]) {
				answer++;
				pre = tmp;
			}
		}
			
		System.out.println(answer);
	}

}