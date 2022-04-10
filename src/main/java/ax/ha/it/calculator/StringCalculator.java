package ax.ha.it.calculator;

import ax.ha.it.calculator.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    
    int sum = 0;
    
    private String seperator = ",|\n";
    
    // Sträng som kommer användas för att använda en ny seperator
    private String customSeperatorIndicator = "//";
    
    // Indikator för att kunna läsa new line
    private String newLineIndicator = "\n";
    
    private String customSeperator = "";
    
    //private String[] customSeperators;
    
    private String numbers = "";
    
    private final Logger logger;
    
    String[] values;

    public StringCalculator(Logger logger) {
        this.logger = logger;
    }
    
    public int add(String text) {
        
        if (text.isEmpty()) {
            return 0;
        }
        if (text.startsWith(customSeperatorIndicator)) {
            String num = setCustomSeperator(text);

            values = num.split(customSeperator);
        } else {
            values = text.split(seperator);
        }
        return sum(values);
        
    }
    
    private int sum(String[] numbers) {
        
        int sum = 0;
        int num = 0;

        for (String currentNumber:numbers) {
            
            num = Integer.parseInt(currentNumber);
            
            if (num >= 1000) {
                logger.log(num);
            }
            
            sum += checkIfNegative(num);
        }

        return sum;
    }
    
    private void multipleCustomSeperators(String seperators) {

        List<String> sep = new ArrayList<String>();
        
        String controller = seperators;
        while (controller.indexOf("[") != -1 && controller.indexOf("]") != -1) {
            
            // Fetching the seperators within the []
            String temp = controller.substring(1, controller.indexOf("]"));
            
            // Updating the controllers values (remove the old [])
            controller = controller.substring(controller.indexOf("]") + 1);

            sep.add(temp);
        }

        //return sep;
        //this.customSeperator = "[";
        this.customSeperator = "";
        for (int i = 0; i < sep.size(); i++) {
            this.customSeperator+=sep.get(i)+"|";
            System.out.println("Adding "+sep.get(i));
        }
        this.customSeperator+= "\n";
    }
    
    private String setCustomSeperator(String input) {
        
        //Delar upp strängen i två delar. En Som innehåller delimitern och en som skall innehålla talen
        String[] sep = input.split("\n", 2);;
        
        // Kod som behövs då användaren själv skirver in \n om inte detta används så fås ett error
        if (sep.length == 1) {
            sep = input.split("\\\\n", 2);
        }
        
        //Delimitern bör vara efter // vilket leder att jag tar en substring efter två chars
        this.customSeperator = sep[0].substring(2);
        
        if (this.customSeperator.indexOf("[") == 0) {
            //List<String> seperators = new ArrayList<>();
            //seperators = 
            multipleCustomSeperators(this.customSeperator);
            System.out.println("Custom seperator is: "+this.customSeperator);
            return sep[1];
        }
        
        if (this.customSeperator.equals("|") || this.customSeperator.equals("*")) {
            //Bättre sätt att lägga till \\ i början av den speciala seperatorn
            this.customSeperator = "\\"+this.customSeperator;
        }
        this.customSeperator = this.customSeperator.concat("|\n");
        //System.out.println("Custom seperator is: "+this.customSeperator);
        
        //Använder den andra delen av inputen som skall innehålla talen som den nya strängen som skall läsas av, om jag inte gör det så får man ett , i början av strängen och får programmet att crasha
        return sep[1];
    }
    
    private int checkIfNegative(int number) {
        //int num = Integer.parseInt(number);
        
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        return number;
        
    }
    
    
    
}
