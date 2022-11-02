package algorithm;

import java.util.HashMap;
import java.util.Map;

public class WhoIsElected {
    public static int compute(int n, int k) {
        Map<Integer, Boolean> excluded = new HashMap<>();
        int currPos = 0;
        int studentCount =n;
        while (n > 0) {
            currPos = currPos + k;
            if (currPos > studentCount) {
                currPos -= studentCount;
            }
            while (excluded.getOrDefault(currPos, false)) {
                currPos++;
            }
            excluded.put(currPos, true);
            n--;
        }
        return currPos;
    }
}
