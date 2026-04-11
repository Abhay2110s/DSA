class set_Mismatch {
    public static int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length + 1];
        int[] res = new int[2];


        for (int num : nums) {
            freq[num]++;
        }


        for (int i = 1; i <= nums.length; i++) {
            if (freq[i] == 2) {
                res[0] = i; 
            } else if (freq[i] == 0) {
                res[1] = i; 
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,2,4};
        int set[] = findErrorNums(arr);
        for(int num : set)
        {
            System.out.print(num + " ");
        }
    }
}