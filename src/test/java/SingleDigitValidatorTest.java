import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import validators.SingleDigitValidator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleDigitValidatorTest {

    SingleDigitValidator singleDigitValidator = new SingleDigitValidator();

    @Test
    void isValidWithDigit(){
        assertTrue(singleDigitValidator.isValid("5"));
    }

    @Test
    void isValidWithSymbol(){
        Assertions.assertThrows(RuntimeException.class, () -> singleDigitValidator.isValid("A"));
    }
}
