package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static List<Integer> getPrimeFactors(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0 && isPrime(i)) {
                primeFactors.add(i);
            }
        }
        if (isPrime(number)) {
            primeFactors.add(number);
        }
        return primeFactors;
    }

    private static boolean isPrime(int input) {
        if (input == 1) {
            return false;
        }
        int count = 0;
        for (int i = 1; i < input; i++) {
            if (input % i == 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
