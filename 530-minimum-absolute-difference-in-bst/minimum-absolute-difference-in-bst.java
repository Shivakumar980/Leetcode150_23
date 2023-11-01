class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }

        prev = root;

        inorderTraversal(root.right);
    }
}
