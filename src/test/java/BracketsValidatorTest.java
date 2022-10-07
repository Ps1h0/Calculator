import org.junit.jupiter.api.Test;
import validators.BracketsValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BracketsValidatorTest {

    private final BracketsValidator bracketsValidator = new BracketsValidator();

    @Test
    void isValidEmptyExpression() {
        assertTrue(bracketsValidator.isValid(""));
    }

    @Test
    void isValidExpressionWithBrackets() {
        assertTrue(bracketsValidator.isValid("()"));
    }

    @Test
    void isValidExpressionWithBracketsAndNumbers() {
        assertTrue(bracketsValidator.isValid("3 + 2"));
    }

    @Test
    void isValidIncorrectBrackets(){
        assertFalse(bracketsValidator.isValid(")("));
    }

    @Test
    void isValidExpressionWithInnerBrackets(){
        assertTrue(bracketsValidator.isValid("(()(())())"));
    }
}
