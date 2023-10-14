package 이중우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    } else {
                        //최댓값 추출
                        if (value == 1) {
                            int maxNum = map.lastKey();
                            int maxCount = map.get(maxNum);
                            if (maxCount == 1) {
                                map.remove(maxNum);
                            } else {
                                map.put(maxNum, maxCount - 1);
                            }
                        } else {
                            int minNum = map.firstKey();
                            int minCount = map.get(minNum);
                            if (minCount == 1) {
                                map.remove(minNum);
                            } else {
                                map.put(minNum, minCount - 1);
                            }
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
