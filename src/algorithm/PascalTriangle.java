package algorithm;

public class PascalTriangle {
    public static void print(int size) {
        for (int i = 0; i < size; i++) {
            for(int j=size;j>=i;j--)
            {
                System.out.print(" ");
            }
            char[] values = String.valueOf((int) Math.pow(11,i)).toCharArray();
            for(char k : values) {
                System.out.print(k+" ");
            }
            System.out.println("");
        }
    }
}
