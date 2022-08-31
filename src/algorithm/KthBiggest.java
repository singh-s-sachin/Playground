package algorithm;

import java.util.*;

public class KthBiggest {
    public static int getBiggest(int[] values, int k) throws Exception {
        int len = values.length;
        if (k > len || k <= 0) {
            throw new Exception("List is smaller than expected smaller. K=" + k + ", Size=" + len);
        }
        for (int i = 0; i < k; i++) {
            int max = i;
            for (int j = i + 1; j < len; j++) {
                if (values[j] > values[max]) {
                    max = j;
                }
            }
            int temp = values[i];
            values[i] = values[max];
            values[max] = temp;
        }
        return values[k - 1];

    }
}
