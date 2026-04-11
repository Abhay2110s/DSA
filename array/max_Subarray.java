public class max_Subarray {
    public static void main(String[] args) {
        int arr[] = {2,4,5,6,7,8,9,7,1};
        int k = 2;
        System.out.println("Maximum sum subarray : "+subarray(arr,k));

    }

    public static int subarray(int[] arr, int k) {
        int i = 0 ,j = 0 ,sum = 0 ,max = 0; 

        while(j<arr.length)
        {
            sum = sum + arr[j];
            if((j-i+1)< k )
            {
                j++;
            }
            else if ((j - i + 1) == k)
            {
                max = Math.max(sum,max);
                sum = sum - arr[i];
                i++;
                j++;
            }
           
        }
        return max;
    }
}
