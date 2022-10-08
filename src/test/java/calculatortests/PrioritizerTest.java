package calculatortests;

import calculator.Prioritizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrioritizerTest {

    private final Prioritizer prioritizer = new Prioritizer();

    @Test
    void plusPriorityLessThanMultPriority() {
        assertTrue(prioritizer.getPriority('+') < prioritizer.getPriority('*'));
    }

    @Test
    void plusPriorityEqualsminusPriority() {
        assertEquals(prioritizer.getPriority('+'), prioritizer.getPriority('-'));
    }

    @Test
    void multPriorityEqualsDivPriority() {
        assertEquals(prioritizer.getPriority('*'), prioritizer.getPriority('/'));
    }

    @Test
    void getPriorityOtherSign() {
        Assertions.assertThrows(RuntimeException.class, () -> prioritizer.getPriority('A'));
    }
}
