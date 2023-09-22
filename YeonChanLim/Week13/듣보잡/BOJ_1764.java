package YeonChanLim.Week13.듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> hash = new HashSet<String>();
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            hash.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String second = br.readLine();
            if(hash.contains(second)){
                list.add(second);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
