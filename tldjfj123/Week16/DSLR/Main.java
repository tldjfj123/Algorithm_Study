package DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최소한의 명령어 -> bfs!!
 * 결과값을 계산하기 위해서는 문자열을 계속해서 업데이트 하면서 진행해야하는데 어떻게 처리해야하는가?? --> 여기까지는 생각했는데 몰라서 풀이봄 ㅎ
 *
 * 풀이
 * 1. Calc 라는 계산 결과와 계산에 사용된 DSLR을 저장할 수 있는 String을 가진 Class를 생성함
 * 2. DSLR 연산을 Calc 안에서 메소드로 작성하여 코드를 간결히함.
 */

public class Main {
    static class Calc {
        int num;
        String res;

        public Calc(int num, String res) {
            this.num = num;
            this.res = res;
        }

        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            if (num == 0) {
                return 9999;
            } else {
                return num - 1;
            }
        }

        // 1000의 자리 -> 1의자리로 & 나머지 숫자들 -> * 10
        int L() {
            return (num % 1000) * 10 + num / 1000;
        }

        // L과 같은 방식으로 1의자리 -> * 1000 & 나머지 숫자들 -> / 10
        int R() {
            return num / 10 + (num % 10) * 1000;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            //9999가 최대값
            Queue<Calc> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];

            queue.add(new Calc(start, ""));
            visited[start] = true;

            while (!queue.isEmpty()) {
                Calc v = queue.poll();

                if (v.num == end) {
                    System.out.println(v.res);
                    break;
                }

                if (!visited[v.D()]) {
                    queue.add(new Calc(v.D(), v.res + "D"));
                    visited[v.D()] = true;
                }
                if (!visited[v.S()]) {
                    queue.add(new Calc(v.S(), v.res + "S"));
                    visited[v.S()] = true;
                }
                if (!visited[v.L()]) {
                    queue.add(new Calc(v.L(), v.res + "L"));
                    visited[v.L()] = true;
                }
                if (!visited[v.R()]) {
                    queue.add(new Calc(v.R(), v.res + "R"));
                    visited[v.R()] = true;
                }
            }
        }

    }
}
