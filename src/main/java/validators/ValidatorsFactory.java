package validators;

import java.util.List;

public final class ValidatorsFactory {

    BracketsValidator bracketsValidator = new BracketsValidator();
    EmptyExpressionValidator emptyExpressionValidator = new EmptyExpressionValidator();
    SingleDigitValidator singleDigitValidator = new SingleDigitValidator();
    SymbolValidator symbolValidator = new SymbolValidator();

    public Validator getValidator() {
        List<Validator> validators = List.of(
                bracketsValidator,
                emptyExpressionValidator,
                singleDigitValidator,
                symbolValidator
        );
        return new ExpressionValidator(validators);
    }
}
