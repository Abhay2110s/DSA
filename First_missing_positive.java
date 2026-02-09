class First_missing_positive
{
    public static int firstMissingPositive(int[] nums) 
    {
        int n= nums.length;
        for(int i = 0 ; i < n ;i++)
        {       // Cyclic sort
            while(nums[i]>0 && nums[i] <= n && nums[nums[i]-1]!= nums[i])
            {
                int index = nums[i] -1;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        // checking the elements aare according to there position
        // the element which is not at its correct position according to the index(i+1) is the smallest positive missing number.
        for(int i = 0 ;i<n ;i++)
        {
            if(nums[i] != i+1)
                return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        int [] arr = {3,4,-1,1};
        int result = firstMissingPositive(arr);
        System.out.println("smallest missing number    "+result);
    }
}