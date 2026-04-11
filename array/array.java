

import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        int arr[] = new int[5];
        Scanner src = new Scanner(System.in);
        System.out.println("Enter the number  ");
        for( int i =0 ; i< 5 ;i++)
        {
            arr[i] = src.nextInt();
        }
        System.out.println("Numbers are   ");
        for (int i = 0 ;i<5 ; i++)
        {
            System.out.println(arr[i]+ " ");
        }
        src.close();
    }
}
