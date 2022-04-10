package ax.ha.it.calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static java.lang.System.out;
import jdk.tools.jaotc.Main;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringCalculatorTest {
    
    //private StringCalculator calc;
    
   /* @BeforeEach
    public void init() {
        calc = new StringCalculator();
    }*/
    
    /*@Test
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
        assertEquals(9, calc2.add("2,2,5"));
    }
    */
    @Test
    public void testWithSpecialDelimiter() {
        StringCalculator calc2 = new StringCalculator(new LoggerStub());
        // Märkte att om delimitern är | så måste det starta med \\| har dock ej lyckats fixa ifall det förekommer flera gånger i rad eller om det förekommer exempelvis likt detta :|:
        assertEquals(16, calc2.add("//|\n5|5|5|1"));
    }
    
    @Test
    public void testWithCustomSepertator() {
        StringCalculator calc2 = new StringCalculator(new LoggerStub());
        assertEquals(11, calc2.add("//a\n5a4a2"));
    }
    
    @Test
    public void testWithCustomSepertatorAndNewLine() {
        StringCalculator calc2 = new StringCalculator(new LoggerStub());
        assertEquals(18, calc2.add("//a\n5a4a2\n2\n5"));
    }
    
    @Test
    public void testWithSpecialDelimiter2() {
        StringCalculator calc2 = new StringCalculator(new LoggerStub());
        // Märkte att om delimitern är | så måste det starta med \\| har dock ej lyckats fixa ifall det förekommer flera gånger i rad eller om det förekommer exempelvis likt detta :|:
        assertEquals(16, calc2.add("//[aa][sss]\n1aa5sss5aa5"));
    }
    /*
    @Test
    public void testWithMultipleNumbers() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(13, calc2.add("//:\n5:2:2:4"));
    }
    
    @Test
    public void testWithNegativeNumber() {
        StringCalculator calc2 = new StringCalculator();
        //assertThrows(0, calc2.add("2,2,-2"));
        
        Exception exception = assertThrows(Exception.class, () -> calc2.add("2,2,-2"));
        //Integer.parseInt("1a");
    }
    
    @Test
    public void testWithValueAt1000() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(1006, calc2.add("1000:2:4"));
    }
    
    @Test
    public void testWithValueOver1000() {
        StringCalculator calc2 = new StringCalculator();
        assertEquals(1006, calc2.add("1000:2:4"));
    }*/
    
    /*public void testAddOnEmptyStringReturnsZero() {
        //StringCalculator calc = new StringCalculator(new LoggerStub()).add("");
        assertEquals(0, new StringCalculator(new LoggerStub()).add(""));
    }
    
    public void testAddOnValue1000() {
        //StringCalculator calc = new StringCalculator(new LoggerStub()).add("");
        assertEquals(1000, new StringCalculator(new LoggerStub()).add("1000"));
    }
    
    public void testLoggerIsCalledOnAdd() {
        Logger mockLogger = mock(Logger.class);
        //mockLogger.log(10);
        //verify(mockLogger).log(10);
        new StringCalculator(mockLogger).add("1000");
        verify(mockLogger, times(1)).log(1000);
        
    }*/
    
    // Skulle här börja tänka att det bör vara bäst att först gå igenom strängen för negativa tal sedan summera dem.
    public void testLoggerIsCalledOnAddAndThereIsANegativeValue() {
        Logger mockLogger = mock(Logger.class);
        Exception exception = assertThrows(Exception.class, () -> new StringCalculator(mockLogger).add("1000,-2"));
    }
}
