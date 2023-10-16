package BOJ9095;

import java.io.*;
// import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[] arr = new int[11];
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    for(int i=4;i<11;i++) arr[i] = arr[i-1] + arr[i-2] + arr[i-3];

    int t = Integer.parseInt(br.readLine());
    for(int i=0;i<t;i++) {
      sb.append(arr[Integer.parseInt(br.readLine())]);
      if(i!=t-1)  sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}

// public class Main {

//   public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     StringBuffer sb = new StringBuffer();
//     Queue<CaseSet> q = new LinkedList<>();
//     int t = Integer.parseInt(br.readLine()), answer, n1, n2, n3, nt;
//     boolean[][][] isChecked = new boolean[11][11][11];
//     for(int i=0;i<t;i++) {
//       q.clear();
//       answer = 0;

//       q.offer(new CaseSet(Integer.parseInt(br.readLine())));
//       while(!q.isEmpty()) {
//         CaseSet curr = q.poll();

//         answer += curr.calc();

//         if(curr.one >= 2) {
//           n1 = curr.one-2;
//           n2 = curr.two+1;
//           n3 = curr.three;
//           nt = n1 + n2 + n3;
//           if(!isChecked[n1][n2][n3]) {
//             q.offer(new CaseSet(n1, n2, n3, nt));
//             isChecked[n1][n2][n3] = true;
//           }
//         }

//         if(curr.one >= 3) {
//           n1 = curr.one-3;
//           n2 = curr.two;
//           n3 = curr.three+1;
//           nt = n1 + n2 + n3;
//           if(!isChecked[n1][n2][n3]) {
//             q.offer(new CaseSet(n1, n2, n3, nt));
//             isChecked[n1][n2][n3] = true;
//           }
//         }

//         if(curr.one >=1 && curr.two >= 1) {
//           n1 = curr.one-1;
//           n2 = curr.two-1;
//           n3 = curr.three+1;
//           nt = n1 + n2 + n3;
//           if(!isChecked[n1][n2][n3]) {
//             q.offer(new CaseSet(n1, n2, n3, nt));
//             isChecked[n1][n2][n3] = true;
//           }
//         }
//       }
//       sb.append(answer);
//       if(i!=t-1)  sb.append("\n");
//     }

//     System.out.println(sb.toString());
    
//   }

//   public static class CaseSet {
//     int one, two, three, total;

//     CaseSet(int n) {
//       this.one = n;
//       this.two = 0;
//       this.three = 0;
//       this.total = n;
//     }

//     CaseSet(int one, int two, int three, int total) {
//       this.one = one;
//       this.two = two;
//       this.three = three;
//       this.total = total;
//     }

//     int calc() {
//       int n = 1, m = 1;
//       for(int i=1;i<=total;i++)  n*=i;
//       for(int i=1;i<=one;i++)  m*=i;
//       for(int i=1;i<=two;i++)  m*=i;
//       for(int i=1;i<=three;i++)  m*=i;

//       return n/m;
//     }

//   }

// }
