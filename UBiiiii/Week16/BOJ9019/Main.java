package BOJ9019;

import java.io.*;
import java.util.*;

public class Main {

  static String answer = "";
  static String[] commands;
  static Queue<Integer> q = new LinkedList<>();
  static int a, b;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      q.clear();
      answer = "";
      commands = new String[10_000];

      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      q.offer(a);
      commands[a] = "";
      while (!q.isEmpty() && answer.length()==0) {
        int tmp = q.poll();

        D(tmp, true);
        S(tmp, true);
        L(tmp, true);
        R(tmp, true);

        if(answer.length()!=0)  break;
      }

      sb.append(answer);
      if (i != t - 1)
        sb.append("\n");
    }

    System.out.println(sb.toString());

  }

  public static void D(int n, boolean dir) {
    int tmp = (2 * n) % 10000;

    if(tmp==b) {
      answer = commands[n]+"D";
      return;
    }

    if(commands[tmp]==null) {
      commands[tmp] = commands[n]+"D";
      q.offer(tmp);
    }
  }

  public static void S(int n, boolean dir) {
    int tmp = n == 0 ? 9999 : n-1;

    if(tmp==b) {
      answer = commands[n]+"S";
      return;
    }

    if(commands[tmp]==null) {
      commands[tmp] = commands[n]+"S";
      q.offer(tmp);
    }
  }

  public static void L(int n, boolean dir) {
    int tmp = (n*10)%10000 + n/1000;
    
    if(tmp==b) {
      answer = commands[n]+"L";
      return;
    }

    if(commands[tmp]==null) {
      commands[tmp] = commands[n]+"L";
      q.offer(tmp);
    }
  }

  public static void R(int n, boolean dir) {
    int tmp = n/10 + (n%10)*1000;
    
    if(tmp==b) {
      answer = commands[n]+"R";
      return;
    }

    if(commands[tmp]==null) {
      commands[tmp] = commands[n]+"R";
      q.offer(tmp);
    }

  }

}
