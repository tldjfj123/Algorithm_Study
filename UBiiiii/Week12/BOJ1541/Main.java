package UBiiiii.Week12.BOJ1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int idx, tmp, answer = 0;
        List<Integer> nums = new ArrayList<>(Arrays.stream(input.split("[+-]")).map(el->Integer.parseInt(el)).collect(Collectors.toList()));
        List<String> symbol = new ArrayList<>(Arrays.stream(input.split("[^+-]")).filter(el->el.length()!=0).collect(Collectors.toList()));
        while(symbol.contains("+")) {
            idx = symbol.indexOf("+");
            tmp = nums.get(idx) + nums.get(idx+1);
            nums.remove(idx);
            nums.set(idx, tmp);
            symbol.remove(idx);
        }
        answer = nums.get(0);
        for(int i=1;i<nums.size();i++) answer -= nums.get(i);
        System.out.println(answer);
    }
}