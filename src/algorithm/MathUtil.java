package algorithm;

public class MathUtil {
    public static boolean isPowerOfTen(int input) {
        int value = 10;
        int power = 1;
        while (input > value) {
            value = (int) Math.pow(value, power);
            power++;
        }
        return value == input;
    }

    public static int power(int base, int power) {
        int value = 1;
        while (power > 0) {
            value *= base;
            power--;
        }
        return value;
    }

    public static int atoi(String input)
    {
        int result = 0;
        int len = input.length();
        for(int i=0;i<len;i++)
        {
            result = result * 10 + (input.charAt(i) - '0');
        }
        return result;
    }
}
