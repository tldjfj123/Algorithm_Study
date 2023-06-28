package YeonChanLim.Week01;

import sun.util.locale.StringTokenIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10871 {
    static int N, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A.length; i++) {
            int count = Integer.parseInt(st.nextToken());
            A[i] = count;
            if(A[i] < X){
                System.out.println(A[i]);
            }

        }
    }
}
