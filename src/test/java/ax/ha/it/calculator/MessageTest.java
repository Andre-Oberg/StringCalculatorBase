/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author André
 */
public class MessageTest {
    
    @Test
    public void testWelcomeMessege() {
        
        
        String welcomeTest = "Welcome to the string calculator!";

        InputStream inputStream = new ByteArrayInputStream(welcomeTest.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(byteOutput);
        System.setOut(outPrintStream);
        
        Main.main(null);
        
        assertEquals("Welcome to the string calculator!\r\n", byteOutput.toString());
        
    }
    
    @Test
    public void testInputString() {
        
        String testString = "scalc '1,2,3'";
        
        InputStream inputStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(byteOutput);
        System.setOut(outPrintStream);
        //PrintStream outputStream = new PrintStream();

        
        Main.main(null);
        assertEquals("The result is 6\r\n", byteOutput.toString());
    }
    
    @Test
    public void testMultipleInput() {
        
        String testString = "scalc '1,2,3'\nscalc '1,2,6'\nscalc '2,2,3'";
        
        InputStream inputStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(byteOutput);
        System.setOut(outPrintStream);
        //PrintStream outputStream = new PrintStream();

        
        Main.main(null);
        assertEquals("The result is 6\n", byteOutput.toString());
    }
    
    
    // Har ingen anning om varför den klagar på index out of bounds här, började testa igenom vanliga programmet
    // både genom att skriva strängen nedan samt kopiera och klista in det som input variabel i main och då fungerar det utan error medelandet
    @Test
    public void testWithNewSeperator() {
        
        String testString = "scalc '//[aaa][bb]\n1aaa2bb4aaa3'";
        
        InputStream inputStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(byteOutput);
        System.setOut(outPrintStream);
        //PrintStream outputStream = new PrintStream();

        
        Main.main(null);
        assertEquals("The result is 10\n", byteOutput.toString());
    }
}
