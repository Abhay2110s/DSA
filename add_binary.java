public class add_binary {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0' ;
            if (j >= 0) sum += b.charAt(j--) - '0' ;

            // if -' 0 ' is not used than '1'+'1' becomes 98 which is the ascii value of 'b' thats why -'0' make '1' of char to 1 of integer.
            
            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        String result = addBinary(a,b);
        System.out.println("Addition of Binary numbers : "+result);
    }
    
}

