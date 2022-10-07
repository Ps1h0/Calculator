import org.junit.jupiter.api.Test;
import validators.SymbolValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SymbolValidatorTest {

    SymbolValidator symbolValidator = new SymbolValidator();

    @Test
    void isValidWithSymbol() {
        assertFalse(symbolValidator.isValid("A"));
    }

    @Test
    void isValidWithNumber() {
        assertTrue(symbolValidator.isValid("5"));
    }

    @Test
    void isValidWithSymbolAndSpaces() {
        assertFalse(symbolValidator.isValid(" A "));
    }
}
