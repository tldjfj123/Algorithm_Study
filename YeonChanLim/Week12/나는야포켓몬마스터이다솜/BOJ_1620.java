package YeonChanLim.Week12.나는야포켓몬마스터이다솜;

/*
포켓몬 추억 돋고~~
문자열 <-> 번호 양 쪽이 연결
문자열로 번호를 찾거나, 번호로 문자열을 찾거나
HashMap<String, Integer> 로 문자열에 맞는 번호를 담고
String[] 로 번호(인덱스) 에 맞는 문자열을 담아
상황에 맞게(입력 값이 문자인지 숫자인지 구분해서)
대응되는 값을 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
        String[] nameArr = new String[N + 1];
        StringBuilder sb = new StringBuilder();

        // 입력
        for(int i = 1; i < N + 1; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            nameArr[i] = name;
        }

        while(M --> 0) {
            String findStr = br.readLine();
            if(isStringNumber(findStr)) { // 숫자(인덱스)를 입력받은 경우
                int index = Integer.parseInt(findStr);
                sb.append(nameArr[index]);
            }
            else {	// 문자를 입력받은 경우
                sb.append(nameMap.get(findStr));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    public static boolean isStringNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
