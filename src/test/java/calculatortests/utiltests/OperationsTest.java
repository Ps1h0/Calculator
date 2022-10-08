package calculatortests.utiltests;

import calculator.util.Operations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationsTest {

    @Test
    void getOperationBySymbol() {
        assertEquals(Operations.PLUS, Operations.getOperationBySymbol('+'));
    }

    @Test
    void getOperationByIncorrectSymbol() {
        assertThrows(RuntimeException.class, () -> Operations.getOperationBySymbol(' '));
    }
}
