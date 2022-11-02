package algorithm;

import java.util.*;

public class AnagramAnalytic {
    public static String getComputedAnagram(String input) {
        String[] anagrams = input.split(" ");
        Map<String, List<Character>> detailedAnagram = new HashMap<>();
        for (String anagram : anagrams) {
            List<Character> anagramChar = new ArrayList<>();
            for (char k : anagram.toCharArray()) {
                anagramChar.add(k);
            }
            detailedAnagram.put(anagram, anagramChar);
        }
        StringBuffer sb = new StringBuffer();
        for (String anagram : anagrams) {
            List<Character> anagramChar = detailedAnagram.get(anagram);
            if (anagramChar == null) {
                continue;
            }
            sb.append(anagram).append(" ");
            detailedAnagram.remove(anagram);
            List<String> redundantVals = new ArrayList<>();
            for (Map.Entry<String, List<Character>> entry : detailedAnagram.entrySet()) {
                boolean isSimilar = true;
                for (char k : entry.getValue()) {
                    if (!anagramChar.contains(k)) {
                        isSimilar = false;
                    }
                }
                if (isSimilar) {
                    redundantVals.add(entry.getKey());
                    sb.append(entry.getKey()).append(" ");
                }
            }
            redundantVals.forEach(redundantVal -> detailedAnagram.remove(redundantVal));
        }
        return sb.toString();
    }
}
