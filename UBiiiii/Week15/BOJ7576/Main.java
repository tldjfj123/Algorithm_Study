package UBiiiii.Week15.BOJ7576;

/*
 * 7576 토마토
 * 7569에서 말했던 예전에 풀었던 토마토 문제. BFS인데 좀 특이하게 풀어보자
 * 매일매일 숙성되는 토마토를 다 큐에 넣고, 이걸 다음날 이용하는 걸로 해봄
 */

import java.io.*;
import java.util.*;

public class Main {

	static int n, m, day, cnt, totalCnt;
	static int[][] box;
	static Queue<int[]> newTomato;
	static Queue<int[]> preTomato;
	static int[] checkX = new int[] {-1, 0, 0, 1};
	static int[] checkY = new int[] {0, 1, -1, 0};
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		box = new int[m][n];
		newTomato = new LinkedList<>();
		preTomato = new LinkedList<>();
		day = 0;
		cnt = 0;
		totalCnt = 0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==1) newTomato.add(new int[] {j,i});
				else if(box[i][j]==0)	cnt++;
			}
		}
		
		while(!newTomato.isEmpty()) {
			day++;
			while(!newTomato.isEmpty()) preTomato.offer(newTomato.poll());
			newTomato.clear();
			while(!preTomato.isEmpty()) {
				int[] tomato = preTomato.poll();
				for(int i=0;i<checkX.length;i++) {
					int nx = tomato[0] + checkX[i];
					int ny = tomato[1] + checkY[i];
					if(nx < 0 || ny < 0 || nx >= n || ny >= m || box[ny][nx]!=0)	continue;
					
					box[ny][nx] = 1;
					newTomato.add(new int[] {nx, ny});
					totalCnt++;
				}
			}
			
		}
		
		System.out.println(cnt==totalCnt ? day-1 : -1);
		
	}
	
}
