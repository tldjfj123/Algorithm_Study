package 집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");

            if (order.length == 1) {
                if (order[0].equals("all")) {
                    set.clear();
                    for (int j = 1; j < 21; j++) {
                        set.add(String.valueOf(j));
                    }
                } else {
                    set.clear();
                }
            } else {
                if (order[0].equals("add")) {
                    set.add(order[1]);
                } else if (order[0].equals("remove")) {
                    set.remove(order[1]);
                } else if (order[0].equals("check")) {
                    if (set.contains(order[1])) {
                        sb.append("1");
                        sb.append("\n");
                    } else {
                        sb.append("0");
                        sb.append("\n");
                    }
                } else {
                    if (set.contains(order[1])) {
                        set.remove(order[1]);
                    } else {
                        set.add(order[1]);
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
