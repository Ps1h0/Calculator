package calculator.validators;

import java.util.Stack;

public class BracketsValidator implements Validator {

    @Override
    public boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char current : expression.toCharArray()) {
            if (current == '(') {
                stack.push(current);
                continue;
            }
            if (current == ')') if (!stack.isEmpty()) {
                char fromStack = stack.peek();
                if (fromStack == '(') stack.pop();
                else return false;
            } else return false;
        }
        return stack.isEmpty();
    }
}
