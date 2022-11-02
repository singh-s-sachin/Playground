package algorithm;

import java.util.*;

public class StringManipulation {
    public static String encodeLength(String input) {
        int len = input.length();
        int count = 1;
        char currChar;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            currChar = input.charAt(i);
            char nextChar;
            if (i + 1 == len) {
                nextChar = '\0';
            } else {
                nextChar = input.charAt(i + 1);
            }
            if (currChar == nextChar) {
                count++;
            } else {
                sb.append(currChar).append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    public static char getFirstNonRepeatingChar(String input) {
        int len = input.length();
        Map<Character, Integer> charMap = new HashMap<>();
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char value = input.charAt(i);
            charList.add(value);
            int count = charMap.getOrDefault(value, 0);
            charMap.put(value, count + 1);
        }
        for (char key : charList) {
            if (charMap.get(key) == 1) {
                return key;
            }
        }
        return '-';
    }

    public static String reverse(String input) {
        StringBuffer sb = new StringBuffer();
        int len = input.length();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static List<Character> getMissingCharFromPanagram(String input) {
        int len = input.length();
        Map<Character, Boolean> visitedMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            visitedMap.put(input.charAt(i), true);
        }
        List<Character> missingChars = new ArrayList<>();
        for (char k = 'a'; k <= 'z'; k++) {
            if (!visitedMap.getOrDefault(k, false)) {
                missingChars.add(k);
            }
        }
        return missingChars;
    }

    public static int distanceBetweenTwoWord(String input, String word1, String word2) {
        String[] words = input.split(" ");
        int minDiff = input.length();
        String prevOccured = null;
        int prevIndex = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1) || word.equals(word2)) {
                if (prevOccured != null && !prevOccured.equals(word)) {
                    int diff = i - prevIndex;
                    if (diff < minDiff) {
                        minDiff = diff;
                    }
                }
                prevOccured = word;
                prevIndex = i;
            }
        }
        return minDiff - 1;
    }
}

