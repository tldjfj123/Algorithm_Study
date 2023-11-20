package 좌표압축;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> tmp = new HashSet<>(arr);

        List<Integer> tmpArr = new ArrayList<>(tmp);
        Collections.sort(tmpArr);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (Integer a : tmpArr) {
            map.put(a, idx);
            idx++;
        }

        StringBuilder sb = new StringBuilder();

        for (Integer a : arr) {
            sb.append(map.get(a) + " ");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
