package BOJ11047;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), answer = 0;
    long price = sc.nextLong();
    int[] coin = new int[n];
    for(int i=0;i<n;i++)  coin[i] = sc.nextInt();

    for(int i=n-1;i>-1;i--) {
      if(coin[i] <= price) {
        answer += price/coin[i];
        price = price%coin[i];
      }
    }

    System.out.println(answer);
    sc.close();
  }
}
