// First number greater than n divisible by sum of digits.

import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter the number   ");
        int n = src.nextInt();

        for(int i = n+1 ; ;i++)
        {   
            int sum =0;
            int temp = i;
            while(temp!=0)
            {
                sum = sum + temp%10;
                temp /=10;
            }
            if(i % sum == 0)
            {
                System.out.println("The first number is    "+i);
                break;
            }
        }

        src.close();
    }
}
