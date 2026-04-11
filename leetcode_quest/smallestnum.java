// How Many Numbers Are Smaller Than the Current Number

class smallestnum {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) count++;
            }
            result[i] = count;
        }

        return result;
    }
        public static void main(String[] args) {
        int arr[] = {1,2,2,4};
        int set[] = smallerNumbersThanCurrent(arr);
        for(int num : set)
        {
            System.out.print(num + " ");
        }
    }
}