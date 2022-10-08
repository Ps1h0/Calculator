package calculator.validators;

import calculator.util.Classifier;

public class SingleDigitValidator implements Validator {

    @Override
    public boolean isValid(String expression) {
        if (expression.trim().length() == 1) {
            char symbol = expression.toCharArray()[0];
            return Classifier.isDigit(symbol);
        }
        return true;
    }
}
