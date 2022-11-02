package algorithm;

import java.util.AbstractMap;
import java.util.Map;

public class PossibleJumps {
    public static int getPossibleJumps(int k, int stairsTop) {//c1+c1
        Map.Entry<String, Integer> countMap = new AbstractMap.SimpleEntry<>("count", 0); //c2
        getPossibleJumpsRec(0, k, stairsTop, countMap);//c1+c1,c1,c1
        return countMap.getValue();//c1
    }

    private static void getPossibleJumpsRec(int currentIndex, int k, int stairsTop, Map.Entry<String, Integer> countMap) { //c1,c1,c1,c2
        if (currentIndex == stairsTop) {
            countMap.setValue(countMap.getValue() + 1);
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (currentIndex+1 > stairsTop) {
                continue;
            }
            getPossibleJumpsRec(currentIndex + i, k, stairsTop, countMap);
        }
    }
}

/**
 * Time complexity
 * O(n) * O(k)
 * O(n^2)
 *
 * Space Complexity
 * cP+ nk(cC)
 * O(n^2)
 */