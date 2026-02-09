
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class balance_bst {
    // List to store the values of the tree in sorted order
    private List<Integer> sortedList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // 1. Flatten the tree into a sorted list
        collectSortedValues(root);
        
        // 2. Rebuild a balanced tree from the sorted list
        return buildBalancedTree(0, sortedList.size() - 1);
    }

    private void collectSortedValues(TreeNode node) {
        if (node == null) return;

        // In-order: Left -> Root -> Right
        collectSortedValues(node.left);
        sortedList.add(node.val);
        collectSortedValues(node.right);
    }

    private TreeNode buildBalancedTree(int start, int end) {
        if (start > end) return null;

        // Choose the middle element as the current root
        int mid = start + (end - start) / 2;
        
        // Create the node with the middle value
        TreeNode newNode = new TreeNode(sortedList.get(mid));

        // Recursively construct left and right subtrees
        newNode.left = buildBalancedTree(start, mid - 1);
        newNode.right = buildBalancedTree(mid + 1, end);

        return newNode;
    }
}