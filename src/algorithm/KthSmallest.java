package algorithm;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallest {
    public static int getKthSmallest(List<Integer> inputs, int k) {
        if (k < inputs.size()) {
            Set<Integer> inputSet = new TreeSet<>();
            inputs.forEach(input -> inputSet.add(input));
            Iterator<Integer> inputIter = inputSet.iterator();
            int response=-1;
            while (k > 0) {
                response = inputIter.next();
                k--;
            }
            return response;
        } else {
            return -1;
        }
    }
}
