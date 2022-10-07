package util;

import validators.Validator;
import validators.ValidatorsFactory;

import java.math.BigDecimal;
import java.util.Stack;

public class Calculator {

    private final Prioritizer prioritizer = new Prioritizer();
    private final ValidatorsFactory factory = new ValidatorsFactory();
    private final Validator expressionValidator = factory.getValidator();

    public double calculate(String expression) {
        if (expressionValidator.isValid(expression)) {
            String checkedNegative = checkNegativeNumbers(expression);
            String rpn = defineOperations(checkedNegative);
            return getAnswer(rpn);
        } else {
            System.err.println("Некорректное выражение");
        }
        return 0;
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

    private String defineOperations(String expression) {
        StringBuilder currentString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int priority;
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            priority = prioritizer.getPriority(currentChar);
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
                    if (prioritizer.getPriority(stack.peek()) >= priority)
                        currentString.append(stack.pop());
                    else break;
                }
                stack.push(currentChar);
                continue;
            }
            if (priority == -1) {
                currentString.append(' ');
                while (prioritizer.getPriority(stack.peek()) != 1)
                    currentString.append(stack.pop());
                stack.pop();
            }
        }
        while (!stack.empty())
            currentString.append(stack.pop());
        return currentString.toString();

    }

    private double getAnswer(String expression) {
        StringBuilder operand = new StringBuilder();
        Stack<Double> stack = new Stack<>();

        if (expression.length() == 1)
            return Double.parseDouble(expression);

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == ' ') continue;
            if (prioritizer.getPriority(symbol) == 0) {
                while (expression.charAt(i) != ' ' && prioritizer.getPriority(expression.charAt(i)) == 0) {
                    operand.append(expression.charAt(i++));
                    if (i == expression.length()) break;
                }
                stack.push(Double.parseDouble(operand.toString()));
                operand = new StringBuilder();
            }
            if (i == expression.length()) continue;
            char operation = expression.charAt(i);
            if (prioritizer.getPriority(operation) > 1) {
                double a = stack.pop();
                double b = stack.pop();
                BigDecimal bda = BigDecimal.valueOf(a);
                BigDecimal bdb = BigDecimal.valueOf(b);
                if (operation == '+') stack.push(bdb.add(bda).doubleValue());
                if (operation == '-') stack.push(bdb.subtract(bda).doubleValue());
                if (operation == '*') stack.push(bdb.multiply(bda).doubleValue());
                if (operation == '/') {
                    if (a == 0) {
                        System.err.println("Деление на ноль");
                        return 0;
                    }
                    stack.push(bdb.divide(bda).doubleValue());
                }
            }
        }
        return stack.pop();
    }
}
