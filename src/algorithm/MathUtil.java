package algorithm;

import java.util.ArrayList;

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

    public static double power(int base, int power) {
        ArrayList<Integer> bitExp = new ArrayList<>();
        while(power > 0) {
            bitExp.add(power%2);
            power = power/2;
        }
        double ans = 1;
        double basePower = base;
        for(int x : bitExp) {
            if(x == 1) {
                ans = ans * basePower;
            }
            basePower = basePower*basePower;
        }
        return ans;
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
