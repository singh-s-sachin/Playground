package algorithm;

import java.util.List;

public class NextGreaterElement {
    public static void print(List<Integer> inputs) {
        int size = inputs.size();
        for (int i = 0; i < size; i++) {
            int currentVal = inputs.get(i);
            int nextGreater = -1;
            for (int j = i + 1; j < size; j++) {
                if (currentVal < inputs.get(j)) {
                    nextGreater = inputs.get(j);
                    break;
                }
            }
            System.out.println(currentVal + "\t=>\t" + nextGreater);
        }
    }
}
