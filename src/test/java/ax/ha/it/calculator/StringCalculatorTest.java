package ax.ha.it.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringCalculatorTest {
    
    @Test
    public void testAddWithEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }
    
    @Test
    public void testAddWithNotEmptyString() {
        assertEquals(1, StringCalculator.add(" "));
    }
    
}
