package calculator.validators;

import java.util.List;

public final class ValidatorsFactory {

    private final BracketsValidator bracketsValidator = new BracketsValidator();
    private final EmptyExpressionValidator emptyExpressionValidator = new EmptyExpressionValidator();
    private final SingleDigitValidator singleDigitValidator = new SingleDigitValidator();
    private final SymbolValidator symbolValidator = new SymbolValidator();
    private final DoubleOperationsValidator doubleOperationsValidator = new DoubleOperationsValidator();

    public Validator getValidator() {
        List<Validator> validators = List.of(
                bracketsValidator,
                emptyExpressionValidator,
                singleDigitValidator,
                symbolValidator,
                doubleOperationsValidator
        );
        return new ExpressionValidator(validators);
    }
}
