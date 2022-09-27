import org.junit.jupiter.api.Test;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void calculateSimpleExpressionOfSum() {
        assertEquals(6, calculator.calculate("3+3"));
    }

    @Test
    void calculateSimpleExpressionOfSubtraction() {
        assertEquals(5, calculator.calculate("10 - 5"));
    }

    @Test
    void calculateSimpleExpressionOfMultiplication() {
        assertEquals(12, calculator.calculate("3 * 4"));
    }

    @Test
    void calculateSimpleExpressionOfDivision() {
        assertEquals(3.0, calculator.calculate("15 / 5"));
    }

    @Test
    void calculateSimpleExpressionOfSumWithNegativeOperands() {
        assertEquals(-5, calculator.calculate("5 - 10"));
    }

    @Test
    void calculateWithSingleArgument() {
        assertEquals(5, calculator.calculate("5"));
    }

    @Test
    void calculateComplexExpression(){
        assertEquals(6, calculator.calculate("2 + 2 * 2"));
    }

    @Test
    void calculateComplexExpressionWithBrackets(){
        assertEquals(8, calculator.calculate("(2 + 2) * 2"));
    }


}