package algorithm;

public class LongestUniformString {
    public static String getLongestUniformSubString(String input) {
        int longestStart = 0;
        int longestString = 0;
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
        String response = "";
        while (longestString != -1) { //O(n)
            response += input.charAt(longestStart++);
            longestString--;
        }
        return response;
    }
}
