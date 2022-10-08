package calculatortests.validatorstests;

import calculator.validators.SingleDigitValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleDigitValidatorTest {

    SingleDigitValidator singleDigitValidator = new SingleDigitValidator();

    @Test
    void isValidWithDigit(){
        assertTrue(singleDigitValidator.isValid("5"));
    }

    @Test
    void isValidWithSymbol(){
        assertFalse(singleDigitValidator.isValid("A"));
    }
}
