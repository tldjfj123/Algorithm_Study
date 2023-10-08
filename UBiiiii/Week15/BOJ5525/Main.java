package UBiiiii.Week15.BOJ5525;

/*
 * 5525 IOIOI
 * 처음 풀이 : 숫자를 세야 하는 문자열을 만들어서 IndexOf를 이용해서 숫자를 세보자 -> 시간초과로 인한 50점
 * 두 번째 풀이 : IOIOI 규칙을 지키는 문자열들만 먼저 문리해내서, 거기에 대해서만 숫자를 세자
 * -> 어차피 주어진 길이가 있으니까, 길이를 이용해서 갯수를 세자
 * -> IOI 규칙을 유지하는 문자열을 한 칸마다 다 세서, 맞으면 배열에 넣고 규칙에 맞는 배열이 다시 시작되면 다시 세는 방식
 */

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m, start = -1, end = -1, answer = 0;
    List<String> lst = new ArrayList<>();
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    String input = br.readLine();
    for (int i = 0; i < m; i++) {
      char tmp = input.charAt(i);
      if (tmp == 'I') {
        if (i<m-1&&input.charAt(i + 1) == 'O')
          if (start == -1)
            start = i;
          else
            continue;
        else {
          if (start != -1) {
            end = i;
            lst.add(input.substring(start, end + 1));
            start = -1;
            end = -1;
          }
        }
      } else {
        if(i<m-1&&input.charAt(i+1)=='O'&&start!=-1) {
          end = i-1;
          lst.add(input.substring(start, end + 1));
          start = -1;
          end = -1;
        } else if (i==m-1&&start!=-1) {
          end = i-1;
          lst.add(input.substring(start, end + 1));
          start = -1;
          end = -1;
        }
      }
    }

    for(String s : lst) if(s.length() >= 2*n+1) {
      int tmp = s.length() - (2*n+1);
      answer += tmp/2+1;
    }

    System.out.println(answer);
  }

}

// import java.io.*;

// public class Main {

//   public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     int n, m, start = 0, answer=0;
//     StringBuffer sb = new StringBuffer("I");
//     n = Integer.parseInt(br.readLine());
//     for(int i=0;i<n;i++)  sb.append("OI");
//     m = Integer.parseInt(br.readLine());
//     String input = br.readLine();
//     String p = sb.toString();
//     while(input.indexOf(p, start)!=-1) {
//       answer++;
//       start = input.indexOf(p, start)+1;
//     }

//     System.out.println(answer);
//   }

// }