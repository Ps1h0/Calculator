package calculatortests;

import calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void calculateSingleDigit(){
        assertEquals(2, calculator.calculate("2"));
    }

    @Test
    void calculateSingleNumber(){
        assertEquals(22, calculator.calculate("22"));
    }

    @Test
    void calculateSingleRealDigit(){
        assertEquals(2.2, calculator.calculate("2.2"));
    }

    @Test
    void calculateSingleRealNumber(){
        assertEquals(22.2, calculator.calculate("22.2"));
    }

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

    @Test
    void calculateRealNumbers(){
        assertEquals(3.45, calculator.calculate("1.2 + 2.25"));
    }
}