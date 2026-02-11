import java.util.*;

public class longest_balanced_subarrayII {
    private int[] minTree;
    private int[] maxTree;
    private int[] lazy;

    private void pushDown(int node, int start, int end) {
        if (lazy[node] != 0) {
            minTree[node] += lazy[node];
            maxTree[node] += lazy[node];
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private void update(int node, int start, int end, int l, int r, int val) {
        if (l > r) return;
        pushDown(node, start, end);
        if (start > end || start > r || end < l) return;
        if (start >= l && end <= r) {
            lazy[node] += val;
            pushDown(node, start, end);
            return;
        }
        int mid = start + (end - start) / 2;
        update(2 * node, start, mid, l, r, val);
        update(2 * node + 1, mid + 1, end, l, r, val);
        minTree[node] = Math.min(minTree[2 * node], minTree[2 * node + 1]);
        maxTree[node] = Math.max(maxTree[2 * node], maxTree[2 * node + 1]);
    }

    private int findLeftmostZero(int node, int start, int end, int l, int r) {
        pushDown(node, start, end);
        // Pruning: if range is invalid or 0 is not within [min, max]
        if (start > r || end < l || minTree[node] > 0 || maxTree[node] < 0) return -1;
        if (start == end) return start;

        int mid = start + (end - start) / 2;
        int leftRes = findLeftmostZero(2 * node, start, mid, l, r);
        if (leftRes != -1) return leftRes;
        return findLeftmostZero(2 * node + 1, mid + 1, end, l, r);
    }

    public int longesttBalanced(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        minTree = new int[4 * n];
        maxTree = new int[4 * n];
        lazy = new int[4 * n];
        Map<Integer, Integer> lastPos = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int val = (nums[i] % 2 != 0) ? 1 : -1;
            
            // If we've seen this number, cancel its previous 'distinct' contribution
            if (lastPos.containsKey(nums[i])) {
                int prevIdx = lastPos.get(nums[i]);
                update(1, 0, n - 1, 0, prevIdx, -val);
            }
            
            // Add current occurrence as the new 'distinct' representative
            update(1, 0, n - 1, 0, i, val);
            lastPos.put(nums[i], i);

            // Find the first index j in [0, i] where prefix sum is 0
            int leftmost = findLeftmostZero(1, 0, n - 1, 0, i);
            if (leftmost != -1) {
                maxLen = Math.max(maxLen, i - leftmost + 1);
            }
        }
        return maxLen;
    }

    // Main method for testing
    public static void main(String[] args) {
        longest_balanced_subarrayII sol = new longest_balanced_subarrayII();
        
        int[] test1 = {1, 2, 1, 2}; 
        System.out.println("Test 1 (Expected 4): " + sol.longesttBalanced(test1));

        int[] test2 = {1, 1, 2, 2, 2};
        System.out.println("Test 2 (Expected 4): " + sol.longesttBalanced(test2));
        
        int[] test3 = {1, 3, 5, 2, 4, 6};
        System.out.println("Test 3 (Expected 6): " + sol.longesttBalanced(test3));
    }
}