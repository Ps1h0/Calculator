package calculator.util;

public class Classifier {

    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    public static boolean isOperation(char c) {
        for (Operations v : Operations.values()) {
            if (v.getSymbolOfOperation() == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOpenedBracket(char c) {
        return c == '(';
    }

    public static boolean isClosedBracket(char c) {
        return c == ')';
    }

    public static boolean isPoint(char c) {
        return c == '.';
    }

    public static boolean isPartOfNumber(char c) {
        return isPoint(c) || isDigit(c);
    }
}
