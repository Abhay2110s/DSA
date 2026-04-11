//! Leetcode 167... Two Sum II - Input Array Is Sorted

public class two_sum_ll {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i<j)
        {
            int sum = numbers[i] + numbers[j];
            if(sum>target)
            {
                j--;
            }
            else if(sum<target)
            {
                i++;
            }
            else
            {
                return new int[] {i+1,j+1};
            }
        }
        return new int [] {-1,-1};
    }

    //* main code
    public static void main(String[] args) {
        int []nums = {2,7,11,15};
        int target = 9;
        int []res = twoSum(nums,target);
        
        for(int r : res)
        {
            System.out.print(r+" ");
        }
    }
}

