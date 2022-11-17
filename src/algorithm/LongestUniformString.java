package algorithm;

public class LongestUniformString {
    public static String getLongestUniformSubString(String input) {
        int longestStart = 0;
        int longestString = Integer.MIN_VALUE;
        int length = input.length();
        int count = 0;
        int start = 0;
        for (int i = 1; i < length; i++) { //O(n)
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                if (count > longestString) {
                    longestString = count;
                    longestStart = start;
                }
                count = 0;
                start = i;
            }
        }

        return input.substring(longestStart,longestStart+longestString+1);
    }
}
