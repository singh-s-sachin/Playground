package algorithm;

public class SumOfFractions {
    /**
     * 2/3 + 1/2 = 7/6
     */
    public static int[] compute(int[] a, int[] b)
    {
        int denominator = a[1] * b[1];
        int numerator = a[0] * b[1] +b[0]*a[1];
        return new int[]{numerator,denominator};
    }
}
