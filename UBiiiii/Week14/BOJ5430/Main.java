package UBiiiii.Week14.BOJ5430;

/*
 * AC
 * 배열을 주고 방향을 바꾼다 + 앞뒤로 빼기도 한다 -> 배열을 써보자
 * 배열 시작과 끝 포인터를 두고, 방향 바꿀 때는 포인터 전환, 뺄 때는 방향에 맞춰서 머리 값만 조정하자
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String[] arr, cmdArr;
	static int head, tail, direction;
	static StringBuilder sb = new StringBuilder();
	static boolean error;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			cmdArr = br.readLine().split("");
			int len = Integer.parseInt(br.readLine());
			String input = br.readLine();
			arr = input.substring(1,input.length()-1).split(",");
			head = 0;
			tail = len-1;
			direction = 1;
			error = false;
			
			for(String cmd : cmdArr) {
				
				if(cmd.equals("D")) {
				
					if(direction>0 ? head>tail : head<tail)	{
						error = true;
						break;
					}
					else	d();
					
				}
				else r();
				
			}
			
			if(error)	sb.append("error").append(i!=n-1?"\n":"");
			else {
        sb.append("[");
				for(int j=head;(direction>0 ? j<=tail : j>=tail);j+=direction) {
					sb.append(arr[j]).append((j==tail ? "" : ","));
				}
				sb.append("]").append(i!=n-1?"\n":"");
			}
		}

    System.out.println(sb.toString());
	}
	
	private static void r() {
		int tmp = head;
		head = tail;
		tail = tmp;
		direction *= -1;
	}
	
	private static void d() {
		head += direction;
	}

}

