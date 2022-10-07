import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Prioritizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrioritizerTest {

    private final Prioritizer prioritizer = new Prioritizer();

    @Test
    void getPriorityClosingBracket() {
        assertEquals(-1, prioritizer.getPriority(')'));
    }

    @Test
    void getPriorityOpeningBracket() {
        assertEquals(1, prioritizer.getPriority('('));
    }

    @Test
    void getPriorityPlus() {
        assertEquals(2, prioritizer.getPriority('+'));
    }

    @Test
    void getPriorityMinus() {
        assertEquals(2, prioritizer.getPriority('-'));
    }

    @Test
    void getPriorityMultiplication() {
        assertEquals(3, prioritizer.getPriority('*'));
    }

    @Test
    void getPriorityDivision() {
        assertEquals(3, prioritizer.getPriority('/'));
    }

    @Test
    void getPriorityDigit() {
        assertEquals(0, prioritizer.getPriority('5'));
    }

    @Test
    void getPrioritySpace() {
        assertEquals(0, prioritizer.getPriority(' '));
    }

    @Test
    void getPriorityOtherSign() {
        Assertions.assertThrows(RuntimeException.class, () -> prioritizer.getPriority('A'));
    }
}
