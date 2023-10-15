package BOJ11399;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()), time=0, answer=0;
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(el->Integer.parseInt(el)).sorted().toArray();
    for(int a : arr)  answer += time += a;
    System.out.println(answer);
    br.close();
  }
}
