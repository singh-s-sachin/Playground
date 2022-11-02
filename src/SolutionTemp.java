import algorithm.*;

import java.util.Arrays;

public class SolutionTemp {
    public static void main(String args[]) throws Exception {
        System.out.println("Fraction to decimal : " + RepeatingDecimalBracket.fractionToDecimal(23, 22));
        //[0,1,3,3,3,3,3,4,4,4,4,4]
        //[4,4,4,4,4,4,4,3,3,3,3,0]
        // 0,0,0,3,2,1,3,0,1,3,0,0
    }
}

/**
 * 1
 * / \
 * 4 2
 * / \ / \
 * 3 3 5 5
 * / \ / \
 * 6 7 6 7
 */