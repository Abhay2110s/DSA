public class power {
    public static double myPow(double x, int n) {

        // Handle basic cases
        if (x == 0) return 0;
        if (n == 0) return 1.0;

        // Convert n to long to handle Integer.MIN_VALUE overflow
        long exp = n;
        
        // If exponent is negative, flip the base and make exponent positive
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;
        while (exp > 0) {
            // If exponent is odd, multiply result by current x
            if (exp % 2 == 1) {
                result *= x;
            }
            // Square the base and halve the exponent
            x *= x;
            exp /= 2;
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.printf("%.5f%n",myPow(2.10000,3));
    }
}
