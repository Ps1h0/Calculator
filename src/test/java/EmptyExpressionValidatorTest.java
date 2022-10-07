import org.junit.jupiter.api.Test;
import validators.EmptyExpressionValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmptyExpressionValidatorTest {

    private final EmptyExpressionValidator emptyExpressionValidator = new EmptyExpressionValidator();

    @Test
    void isValidNotEmptyExpression() {
        assertTrue(emptyExpressionValidator.isValid("3 + 3"));
    }

    @Test
    void isValidEmptyExpression() {
        assertFalse(emptyExpressionValidator.isValid(""));
    }

    @Test
    void isValidWithSpaceExpression(){
        assertFalse(emptyExpressionValidator.isValid(" "));
    }

    @Test
    void isValidWithManySpacesExpression(){
        assertFalse(emptyExpressionValidator.isValid("     "));
    }
}
