package algorithm;

public class SmallestSubArrayExceedingTarget {
    public static int compute(int[] a, int sum) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            int tempSum = 0, subArrLen = 0;
            for (int j = i; j < a.length && tempSum <= sum; j++) {
                tempSum += a[j];
                subArrLen=j-i+1;
            }
            if(tempSum<sum)
            {
                if(i==0)
                {
                    minLen=-1;
                }
                break;
            }
            if(minLen>subArrLen)
            {
                minLen=subArrLen;
            }
        }
        return minLen;
    }
}
