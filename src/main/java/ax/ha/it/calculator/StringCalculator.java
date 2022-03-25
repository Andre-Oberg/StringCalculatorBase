package ax.ha.it.calculator;

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
    
    String[] values;
    
    public int add(String text) {
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
        
        System.out.println("Before For Loop");
        for (String currentNumber:numbers) {
            sum += checkIfNegative(currentNumber);
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
    
    private int checkIfNegative(String number) {
        int num = Integer.parseInt(number);
        
        if (num < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        return num;
        
    }
    // Funktion för att addera alla potentiella tal som finns i strängen
    /*private int sum(String string){
        
        // Sträng som kommer innehålla talen som hittas i input strängen
        String num = "0";
        int sum = 0;
        
        for (int i=0; i < string.length(); i++) {

            
            // Naiv implementation för kontrol av negatigva tal. Detta kommer fungera så länge
            // - inte är det sista talet i strängen annars leder det till index out of range
            if (string.charAt(i) == '-' && Character.isDigit(string.charAt(i+1))) {
                System.out.println("Do i spy a negative number!?");
                return 0;
            }
            
            // Ifall talet skulle vara exempelvis 10, 11 tolv så behöver man lägga till
            // de extra siffrorna i en seperat sträng, sedan när en icke siffra förekommer så
            // plockar man ut talet
            if (Character.isDigit(string.charAt(i))) {
                num += string.charAt(i);
            } else {
                sum += Integer.parseInt(num);
                
                // "Nollar" strängen så att inget blir kvar av det som fanns tidigare
                num = "0";
            }
            
            // Behöver ett sätt att hämta ut det sista i strängen 
            if (i == string.length()-1) {
                sum += Integer.parseInt(num);
            }
        }
       
        return sum;
    }*/
}
