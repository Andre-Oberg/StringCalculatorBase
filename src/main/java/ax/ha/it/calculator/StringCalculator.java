package ax.ha.it.calculator;

import ax.ha.it.calculator.Logger;
import java.util.Arrays;

public class StringCalculator {
    
    int sum = 0;
    
    private String seperator = ",|\n";
    
    // Sträng som kommer användas för att använda en ny seperator
    private String customSeperatorIndicator = "//";
    
    // Indikator för att kunna läsa new line
    private String newLineIndicator = "\n";
    
    private String customSeperator = "";
    
    private String numbers = "";
    
    private final Logger logger;
    
    String[] values;

    public StringCalculator(Logger logger) {
        this.logger = logger;
    }
    
    public int add(String text) {
        
        //logger.log("StringCalculator.Add() was called");
        
        if (text.isEmpty()) {
            return 0;
        }
        if (text.startsWith(customSeperatorIndicator)) {
            String num = setCustomSeperator(text);
            //String temp = text.substring(2);
            //System.out.println("Text is: "+customSeperator);
            values = num.split(customSeperator);
            
            System.out.print("If Values is "+Arrays.toString(values));
        } else {
            values = text.split(seperator);
            System.out.print("Values is "+Arrays.toString(values));
        }
        return sum(values);
        
    }
    
    private int sum(String[] numbers) {
        
        int sum = 0;
        int num = 0;
        
        System.out.println("Before For Loop");
        for (String currentNumber:numbers) {
            
            num = Integer.parseInt(currentNumber);
            
            if (num >= 1000) {
                logger.log(num);
            }
            
            sum += checkIfNegative(num);
        }
         System.out.println("After For Loop");   
        return sum;
    }
    
    private String setCustomSeperator(String input) {
        //Delar upp strängen i två delar. En Som innehåller delimitern och en som skall innehålla talen
        String[] sep = input.split("\n", 2);
        
        
        //Delimitern bör vara efter // vilket leder att jag tar en substring efter två chars
        this.customSeperator = sep[0].substring(2);
        //this.customSeperator = sep[0].substring(2);
        //System.out.println("Set Custom 1: "+this.customSeperator);
        
        if (this.customSeperator.equals("|")) {
            
            this.customSeperator = "\\|";
            System.out.println("Set Custom IF: "+this.customSeperator);
        }
        this.customSeperator = this.customSeperator.concat("|\n");
        System.out.println("Set Custom 2: "+this.customSeperator);
        
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
