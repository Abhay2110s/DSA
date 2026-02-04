public class trionic {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false; // Not enough elements to form Up-Down-Up
        
        int i = 1;

        // 1. First Phase: Increase (Up)
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }
        

        if (i == 1 || i == n) return false;

        // 2. Second Phase: Decrease (Down)
        int peak1 = i;
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }

        if (i == peak1 || i == n) return false;

        // 3. Third Phase: Increase (Up)
        int valley = i;
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == n && i > valley;
    }
}
