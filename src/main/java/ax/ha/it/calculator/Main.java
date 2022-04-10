/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.calculator;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author André
 */
public class Main {
    
    
    static String welcomeMessege = "Welcome to the string calculator!";
    static StringCalculator calc = new StringCalculator(new LoggerStub());
    
    
    
    public static void main(String[] args) {
        
        String input = "temp";
        //String input = "scalc '//aaa\n1aaa2aaa4'";
        String numbers = null;
        int res = 0;
        
        System.out.println(welcomeMessege);
        
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            input = scanner.nextLine();
            //Kontroll för att verifiera att strängen startar med scalc samt att den är längre än 7 (för att veta att det inte bara står scalc ')
            if (input.indexOf("scalc", 0) == 0 && input.length() > 7) {
                try {
                    // Snabb sätt att få ut värdena för add. Då "scalc '" är 7 chars lång samt vet att det skall sluta med ' 
                    // så behöver man bara använda substring(7, input.length()-1) för att få alla värden
                    numbers = input.substring(7, input.length()-1);
                    System.out.println("The result is "+calc.add(numbers));
                } catch (Exception error) {
                    System.err.println(error);
                }
            } else if (input.length() <= 0) {
                System.out.println("");
                break;
            } else {
               System.out.println("Please enter <scalc > with your values within two <'> and seperated with <,>");
            }
         }
        
        //System.out.println("Thanks for using the String Calculator, bye!"); 
    }

}
