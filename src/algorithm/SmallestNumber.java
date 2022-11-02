package algorithm;

import java.util.List;

public class SmallestNumber {
    /*
     * public static int FindMin(int a[])
     * Returns the smallest number in array that has been rotated
     * For example - Array {3,4,5,6,1,2} returns 1
     */
    public static int getSmallestNumber(List<Integer> inputs)
    {
        int smallest = Integer.MAX_VALUE;
        for(int input : inputs)
        {
            if(input<smallest)
            {
                smallest=input;
            }
        }
        return smallest;
    }
}
