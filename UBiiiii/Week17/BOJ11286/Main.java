package BOJ11286;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    TreeMap<Integer, Integer> map = new TreeMap<>((a,b)->Math.abs(a)==Math.abs(b) ? a-b :Math.abs(a)-Math.abs(b));
    int n = Integer.parseInt(br.readLine());
    for(int i=0;i<n;i++) {
      int input = Integer.parseInt(br.readLine());
      if(input==0) {
        if(map.size()==0) sb.append(0).append("\n");

        else {
          int tmp = map.firstKey();
          sb.append(tmp).append("\n");
          if(map.get(tmp)==1) map.remove(tmp);
          else                map.put(tmp, map.get(tmp)-1);
        }
      } else {
        map.put(input, map.getOrDefault(input, 0)+1);
      }

    }

    System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
  }
}
