package algorithm;

public class PascalTriangle {
    public static void print(int size) {
        for(int i = 1; i <= size; i++)
        {
            for(int k=i;k<=size;k++)
            {
                System.out.print(" ");
            }
            int C=1;
            for(int j = 1; j <= i; j++)
            {
                System.out.print(C+" ");
                C = C * (i - j) / j;
            }
            System.out.println();
        }
    }
}
