
import java.util.Scanner;

public class binary_search {

    public static int binary(int a[],int n,int t)
    {
        for(int i = 0 ;i<n ;i++)
        {
            if(a[i] == t )
            {
                return i;
                
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,4,55,6,77};
        int n = arr.length;
        System.out.println("Enter the target element");
        Scanner src = new Scanner(System.in);
        int target = src.nextInt();
        int i = binary(arr, n , target);
        if (i ==-1) {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println("Element found at position -: "+(i+1));
        }
        src.close();
    }
}
