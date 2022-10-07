package util;

import java.util.Map;

public class Prioritizer {

    private final Map<Character, Integer> PRIORITY = Map.of(
            ')', -1,
            '(', 1,
            '+', 2,
            '-', 2,
            '*', 3,
            '/', 3
    );

    public int getPriority(char token) {
        if (PRIORITY.containsKey(token))
            return PRIORITY.get(token);
        if (Character.isDigit(token))
            return 0;
        else throw new RuntimeException();
    }
}
