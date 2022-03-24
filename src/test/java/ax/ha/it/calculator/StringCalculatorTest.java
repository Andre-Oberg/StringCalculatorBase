package ax.ha.it.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringCalculatorTest {
    
    //private StringCalculator calc;
    
   /* @BeforeEach
    public void init() {
        calc = new StringCalculator();
    }*/
    
    @Test
    public void testEmptyString() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(0, calc2.add(""));
    }
    
    @Test
    public void testAddWithNotEmptyString() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(1, calc2.add("1"));
    }
    
    @Test
    public void testWithTwoNumbers() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(4, calc2.add("2,2"));
    }
    
    @Test
    public void testWithThreeNumbers() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(9, calc2.add("2,2,5"));
    }
    
    @Test
    public void testWithNewLine() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(13, calc2.add("1,2,5\n5"));
    }
    
    @Test
    public void testWithMultipleSeperatorsInARow() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(9, calc2.add("2,,2,5"));
    }
    
    /*@Test
    public void testWithMultipleNumbers() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(37, calc2.add("5 5.22,2a3aa"));
    }
    
    @Test
    public void testWithNewLine() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(5, calc2.add("//1:;2\n2"));
    }
    
    @Test
    public void testWithNegativeNumber() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(0, calc2.add("11//2-a -2"));
    }
    
    @Test
    public void testWithNegativeSignAtEnd() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(0, calc2.add("11//2-a - 2-"));
    }*/
}
