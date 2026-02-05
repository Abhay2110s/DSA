//https://leetcode.com/problems/transformed-array/description/?envType=daily-question&envId=2026-02-05

;public class transformed_array {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                result[i] = nums[i];
            } 
            else {
 
                int targetIndex = ((i + nums[i]) % n + n) % n;
                result[i] = nums[targetIndex];
            }
        }
        
        return result;

    }
    
}
