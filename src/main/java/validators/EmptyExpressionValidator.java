package validators;

public class EmptyExpressionValidator implements Validator {

    @Override
    public boolean isValid(String expression) {
        return expression.length() > 0;
    }
}
