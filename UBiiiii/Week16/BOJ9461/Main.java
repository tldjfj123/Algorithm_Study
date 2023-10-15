package BOJ9461;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine()), max = 0;
    int[] input = new int[n];
    for(int i=0;i<n;i++) {
      input[i] = Integer.parseInt(br.readLine());
      max = Math.max(max, input[i]);
    }

    long[] arr = new long[Math.max(5, max)];
    arr[0] = arr[1] = arr[2] = 1;
    arr[3] = arr[4] = 2;
    for(int i=5;i<max;i++) arr[i] = arr[i-5] + arr[i-1];

    for(int i : input) {
      sb.append(arr[i-1]);
      if(i!=input[input.length-1])  sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
