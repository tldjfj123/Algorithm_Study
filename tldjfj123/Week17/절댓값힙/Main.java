package 절댓값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static class Calc  {
        int oValue;
        int aValue;

        public Calc(int oValue, int aValue) {
            this.oValue = oValue;
            this.aValue = aValue;
        }
    }

    static class CalcComparator implements Comparator<Calc> {
        @Override
        public int compare(Calc o1, Calc o2) {
            if (o1.aValue == o2.aValue) {
                return o1.oValue - o2.oValue;
            } else {
                return o1.aValue - o2.aValue;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Calc> heap = new PriorityQueue<Calc>(new CalcComparator());

        for (int i = 0; i < n; i++) {
            int order = Integer.parseInt(br.readLine());

            if (order == 0) {
                if (heap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll().oValue);
                }
            } else {
                heap.add(new Calc(order, Math.abs(order)));
            }
        }

    }
}
