package ax.ha.it.calculator;

public class StringCalculator {
    
    public int add(String text) {
        if (text.isEmpty()) {
            return 0;
        } else { 
            return sum(text);
        }
    }
    
    // Funktion för att addera alla potentiella tal som finns i strängen
    private int sum(String string){
        
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
    }
}
