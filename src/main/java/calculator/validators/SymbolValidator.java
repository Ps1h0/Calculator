package calculator.validators;

public class SymbolValidator implements Validator {

    @Override
    public boolean isValid(String expression) {
        return !expression.matches(".*[A-Za-z].*") && !expression.matches("\s*\\.\s*");
    }
}
