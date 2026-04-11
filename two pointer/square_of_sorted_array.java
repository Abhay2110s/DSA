//! Leetcode 977....
//? First square the elements of the array and then sort them in ascending order..

import java.util.Arrays;
public class square_of_sorted_array{

    public static int[] sortedSquares(int[] nums) {
        int []res = new int[nums.length];
        int i = 0 ;
        int j = nums.length-1;
        int k = nums.length-1;

        while(i<=j)
        {
            int sqi = nums[i]*nums[i];
            int sqj = nums[j]*nums[j];
            
            if(sqi>sqj)
            {
                res[k] = sqi;
                i++;
            }
            else{
                res[k]=sqj;
                j--;
            }
            k--;
        }
        return res;
    }
    public static void main(String[] args) {
        int []arr = {-7,-3,2,3,11};
        int []res = sortedSquares(arr);

        System.out.println(Arrays.toString(res));
    }
}