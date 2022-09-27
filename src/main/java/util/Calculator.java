package util;

import java.util.Map;
import java.util.Stack;

public class Calculator {

    private final Map<Character, Integer> PRIORITY = Map.of(')', -1, '(', 1, '+', 2, '-', 2, '*', 3, '/', 3);

    public double calculate(String expression) {
        expression = checkLengthOfExpression(expression);
        if (!checkBrackets(expression)) {
            System.err.println("Некорректно расставлены скобки");
            System.exit(0);
        } else {
            String checkedNegative = checkNegativeNumbers(expression);
            String rpn = defineOperations(checkedNegative);
            return getAnswer(rpn);
        }
        return 0;
    }

    private String checkLengthOfExpression(String expression) {
        StringBuilder number = new StringBuilder();
        if (expression.length() == 0) {
            System.err.println("Пустое выражение");
            System.exit(0);
        }
        if (expression.trim().length() == 1) {
            char symbol = expression.toCharArray()[0];
            if (getPriority(symbol) != 0) {
                System.err.println("Некорректное выражение");
                System.exit(0);
            } else
                return expression + " + 0";
        } else {
            for (int i = 0; i < expression.length(); i++) {
                char current = expression.charAt(i);
                if (getPriority(current) != 0)
                    return expression;
                else
                    number.append(current);
            }
            return number + " + 0";
        }
        return expression;
    }

    private String checkNegativeNumbers(String expression) {
        StringBuilder checkedNegative = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '-') {
                if (i == 0)
                    checkedNegative.append('0');
                else if (expression.charAt(i - 1) == '(')
                    checkedNegative.append('0');
            }
            checkedNegative.append(symbol);
        }
        return checkedNegative.toString();
    }

    private boolean checkBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char current : expression.toCharArray()) {
            if (current == '(') {
                stack.push(current);
                continue;
            }
            if (current == ')')
                if (!stack.isEmpty()) {
                    char fromStack = stack.peek();
                    if (fromStack == '(')
                        stack.pop();
                    else
                        return false;
                } else
                    return false;
        }
        return stack.isEmpty();
    }

    private String defineOperations(String expression) {
        StringBuilder currentString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int priority;
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            priority = getPriority(currentChar);
            if (priority == 0) {
                currentString.append(currentChar);
                continue;
            }
            if (priority == 1) {
                stack.push(currentChar);
                continue;
            }
            if (priority > 1) {
                currentString.append(' ');
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority)
                        currentString.append(stack.pop());
                    else break;
                }
                stack.push(currentChar);
                continue;
            }
            if (priority == -1) {
                currentString.append(' ');
                while (getPriority(stack.peek()) != 1) currentString.append(stack.pop());
                stack.pop();
            }
        }
        while (!stack.empty())
            currentString.append(stack.pop());
        return currentString.toString();
    }

    private double getAnswer(String str) {
        StringBuilder operand = new StringBuilder();
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (symbol == ' ')
                continue;
            if (getPriority(symbol) == 0) {
                while (str.charAt(i) != ' ' && getPriority(str.charAt(i)) == 0) {
                    operand.append(str.charAt(i++));
                    if (i == str.length())
                        break;
                }
                stack.push(Double.parseDouble(operand.toString()));
                operand = new StringBuilder();
            }
            char operation = str.charAt(i);
            if (getPriority(operation) > 1) {
                double a = stack.pop();
                double b = stack.pop();
                if (operation == '+') stack.push(b + a);
                if (operation == '-') stack.push(b - a);
                if (operation == '*') stack.push(b * a);
                if (operation == '/') {
                    if (a == 0) {
                        System.err.println("Деление на ноль");
                        System.exit(0);
                    }
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }

    private int getPriority(char token) {
        if (PRIORITY.containsKey(token))
            return PRIORITY.get(token);
        return 0;
    }
}
