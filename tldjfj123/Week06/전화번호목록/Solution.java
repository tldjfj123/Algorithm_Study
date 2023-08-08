import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        HashSet<String> prefixes = new HashSet<>();

        for (String p : phoneBook) {
            for (int i = 0; i < p.length(); i++) {
                if (prefixes.contains(p.substring(0, i))) {
                    return false;
                }
            }
            prefixes.add(p);
        }
        return true;
    }
}