package BOJ1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(dnc(0, 0, (int)Math.pow(2, n)-1, (int)Math.pow(2, n)-1, 0));
    }

    private static long dnc(int sx, int sy, int ex, int ey, long cnt) {
        if(sx==ex && sy==ey) {
            return cnt;
        }

        int hx = (sx+ex)/2;
        int hy = (sy+ey)/2;
        long blockSize = (long)Math.pow((ex-sx+1)/2, 2);

        if(r<=hx&&c<=hy)    return dnc(sx, sy, hx, hy, cnt);
        else if(r<=hx&&c>hy)    return dnc(sx, hy+1, hx, ey, cnt+blockSize*1);
        else if(r>hx&&c<=hy)    return dnc(hx+1, sy, ex, hy, cnt+blockSize*2);
        else     return dnc(hx+1, hy+1, ex, ey, cnt+blockSize*3);
    }
}
