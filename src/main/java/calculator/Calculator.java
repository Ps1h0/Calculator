package calculator;

import calculator.util.Classifier;
import calculator.util.Operations;
import calculator.validators.Validator;
import calculator.validators.ValidatorsFactory;

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
        Stack<Character> operationsStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (Classifier.isPartOfNumber(currentChar)) {
                currentString.append(currentChar);
            } else if (Classifier.isOpenedBracket(currentChar)) {
                operationsStack.push(currentChar);
            } else if (Classifier.isOperation(currentChar)) {
                currentString.append(' ');
                int priority = prioritizer.getPriority(currentChar);
                while (!operationsStack.empty()) {
                    if (prioritizer.getPriority(operationsStack.peek()) >= priority)
                        currentString.append(operationsStack.pop());
                    else break;
                }
                operationsStack.push(currentChar);
            } else if (Classifier.isClosedBracket(currentChar)) {
                currentString.append(' ');
                while (prioritizer.getPriority(operationsStack.peek()) != 1)
                    currentString.append(operationsStack.pop());
                operationsStack.pop();
            }
        }
        while (!operationsStack.empty())
            currentString.append(operationsStack.pop());
        return currentString.toString();
    }

    private double getAnswer(String expression) {
        StringBuilder operand = new StringBuilder();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == ' ') continue;
            if (Classifier.isPartOfNumber(symbol)) {
                while (expression.charAt(i) != ' ' && Classifier.isPartOfNumber(expression.charAt(i))) {
                    operand.append(expression.charAt(i++));
                    if (i == expression.length()) break;
                }
                stack.push(Double.parseDouble(operand.toString()));
                operand = new StringBuilder();
            }
            if (i == expression.length()) continue;
            char operation = expression.charAt(i);
            if (Classifier.isOperation(operation)) {
                double a = stack.pop();
                double b = stack.pop();
                BigDecimal bda = BigDecimal.valueOf(a);
                BigDecimal bdb = BigDecimal.valueOf(b);
                Operations o = Operations.getOperationBySymbol(operation);
                stack.push(o.perform(bdb, bda).doubleValue());
            }
        }
        return stack.pop();
    }
}
