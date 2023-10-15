package BOJ9375;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    for(int i=0;i<n;i++) {
      Map<String, Integer> map = new HashMap<>();
      int m = Integer.parseInt(br.readLine()), cnt = 1;
      for(int j=0;j<m;j++) {
        String[] input = br.readLine().split(" ");
        map.put(input[1], map.getOrDefault(input[1], 0)+1);
      }

      for(String key : map.keySet())  cnt *= map.get(key)+1;
      sb.append(cnt-1);
      if(i!=n-1)  sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
