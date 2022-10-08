package calculator;

import calculator.util.Operations;

import java.util.Map;

public class Prioritizer {

    private final Map<Character, Integer> PRIORITY = Map.of(
            ')', -1,
            '(', 1,
            Operations.PLUS.getSymbolOfOperation(), 2,
            Operations.MINUS.getSymbolOfOperation(), 2,
            Operations.MULT.getSymbolOfOperation(), 3,
            Operations.DIV.getSymbolOfOperation(), 3
    );

    public int getPriority(char token) {
        if (PRIORITY.containsKey(token))
            return PRIORITY.get(token);
        if (Character.isDigit(token) || token == ' ' || token == '.')
            return 0;
        throw new RuntimeException("Некорректное выражение");
    }
}
