package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PasswordSuggester {
    private static final Map<Character, Character> REPLACEABLE = new HashMap<>() {{
        put('a', '@');
        put('s', '$');
        put('o', '0');
    }};

    public Set<String> getSuggestions(String password) {
        int len = password.length();
        Set<String> suggestions = new HashSet<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                suggestions.add(addSuggestions(password, i, j, len));
            }
        }
        return suggestions;
    }

    private String addSuggestions(String password, int from, int to, int len) {
        String suggestedPass = "";

        for (int i = 0; i < len; i++) {
            char k = password.charAt(i);
            if (i >= from && i <= to) {
                k = REPLACEABLE.getOrDefault(k, k);
            }
            suggestedPass += k;
        }
        return suggestedPass;
    }
}
