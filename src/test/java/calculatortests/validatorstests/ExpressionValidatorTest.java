package calculatortests.validatorstests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import calculator.validators.EmptyExpressionValidator;
import calculator.validators.ExpressionValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpressionValidatorTest {

    ExpressionValidator expressionValidatorWithNullList = new ExpressionValidator(null);
    ExpressionValidator expressionValidatorWithEmptyList = new ExpressionValidator(new ArrayList<>());
    ExpressionValidator expressionValidator = new ExpressionValidator(List.of(new EmptyExpressionValidator()));

    @Test
    void getValidatorWithNullList() {
        Assertions.assertThrows(NullPointerException.class, () -> expressionValidatorWithNullList.isValid("3 + 3"));
    }

    @Test
    void getValidatorWithEmptyList() {
        assertTrue(expressionValidatorWithEmptyList.isValid("3 + 3"));
    }

    @Test
    void getValidatorWithNotEmptyList() {
        assertTrue(expressionValidator.isValid("3 + 3"));
    }
}
