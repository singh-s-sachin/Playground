package algorithm;

import java.util.HashMap;
import java.util.Map;

public class RepeatingDecimalBracket {
    public static String fractionToDecimal(int num, int den) {
        Map<Integer, Integer> remainders = new HashMap<>();
        String quotient = String.valueOf(num / den);
        int remainder = num % den;
        String remainderStr = "";
        while (remainder != 0 && !remainders.containsKey(remainder)) {
            remainders.put(remainder, remainderStr.length());
            remainderStr += (remainder * 10) / den;
            remainder = (remainder * 10) % den;
        }
        if (remainder == 0) {
            return quotient.concat(".")
                    .concat(remainderStr);
        } else {
            return quotient.concat(".")
                    .concat(remainderStr.substring(0, remainders.get(remainder))
                            .concat("(")).concat(remainderStr.substring(remainders.get(remainder)))
                    .concat(")");
        }
    }

}
