package YeonChanLim.Week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int isPN;
        int cnt = 0;

        for(int i=0; i < num; i++){
            isPN = Integer.parseInt(st.nextToken());
            
            for(int p=2; p<=isPN; p++){
                if(p == isPN){
                    cnt++;
                }
                if(isPN % p == 0){
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

}
