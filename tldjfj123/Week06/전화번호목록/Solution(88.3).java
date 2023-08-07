import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        HashMap<String, Integer> table = new HashMap<>();

        for (String p : phoneBook) {
            if (table.isEmpty()) {
                table.put(p, 1);
            } else {
                boolean foundPrefix = false;
                for (String key : table.keySet()) {
                    if (p.startsWith(key)) {
                        foundPrefix = true;
                        break;
                    }
                }
                if (foundPrefix) {
                    return false;
                } else {
                    table.put(p, 1);
                }
            }
        }
        return true;
    }
}
