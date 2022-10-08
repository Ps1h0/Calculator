package calculator.validators;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ExpressionValidator implements Validator {

    private final List<Validator> validators;

    @Override
    public boolean isValid(String expression) {
        for (Validator validator : validators) {
            if (!validator.isValid(expression))
                return false;
        }
        return true;
        }
    }
