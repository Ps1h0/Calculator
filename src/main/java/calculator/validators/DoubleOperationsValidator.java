package calculator.validators;

import calculator.util.Classifier;

public class DoubleOperationsValidator implements Validator {

    @Override
    public boolean isValid(String expression) {
        for (int i = 0; i < expression.length() - 1; i++) {
            if (Classifier.isOperation(expression.charAt(i)) && Classifier.isOperation(expression.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
