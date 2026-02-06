import java.util.Arrays;
public class min_removal {

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxKept = 0;
        int right = 0;

        // Sliding window
        for (int left = 0; left < n; left++) {
            // Move right pointer as long as the balance condition holds
            while (right < n && (long) nums[right] <= (long) nums[left] * k) {
                right++;
            }
            // Number of elements in current valid window is (right - left)
            maxKept = Math.max(maxKept, right - left);
        }

        // Minimum removals = Total - Maximum elements kept
        return n - maxKept;
    }
}

