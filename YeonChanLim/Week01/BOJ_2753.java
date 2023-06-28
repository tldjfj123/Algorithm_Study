package YeonChanLim.Week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2753 {
    static int year;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        year = Integer.parseInt(st.nextToken());

        if(year%4==0){
            if (year%400 == 0) {
                System.out.println("1");
            }else if (year%100 == 0) {
                System.out.println("0");
            }else {
                System.out.println("1");
            }
        }else {
            System.out.println("0");
        }
    }
}
