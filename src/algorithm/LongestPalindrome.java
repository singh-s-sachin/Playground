package algorithm;

public class LongestPalindrome {
    public static String compute(String input) {
        int ipLen = input.length();
        for (int i = 0; i < ipLen; i++) {
            if (isPalindrome(input, i, ipLen - 1)) {
                return input.substring(i, ipLen);
            }
            if (isPalindrome(input, 0, ipLen - i - 1)) {
                return input.substring(0, ipLen - i);
            }
            if (isPalindrome(input, i, ipLen - i - 1)) {
                return input.substring(i, ipLen - i);
            }
        }
        return null;
    }

    /**
     * 1 - 15
     * pointer1=1,2,3
     * pointer2=15,14,13
     */

    private static boolean isPalindrome(String input, int from, int to) {
        String spawnedStr = "", reversedSpawnedStr = "";
        int m = 0;
        for (int i = from; i < to; i++, m++) {//i=1->15
            spawnedStr += input.charAt(i);
            reversedSpawnedStr += input.charAt(to - m);
        }
        return spawnedStr.equals(reversedSpawnedStr);
    }
}
