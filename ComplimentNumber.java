import java.util.*;

public class ComplimentNumber { // Class names should be CamelCase
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter the number : "); // Changed to print for a cleaner input line
        

        int num = src.nextInt();
        
        // 1. Convert to Binary
        String binary = Integer.toBinaryString(num);
        
        // 2. Use StringBuilder for better performance
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            
            // 3. Flip the bits
            if (bit == '0') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        
        // 4. Convert back to Integer
        // Note: Using a Binary String that represents a very large number 
        // might exceed Integer.MAX_VALUE. For safety, we use parseInt.
        int res = Integer.parseInt(result.toString(), 2);
        
        System.out.println("Binary representation: " + binary);
        System.out.println("The compliment of the number is : " + res);
        
        src.close();
    }
}