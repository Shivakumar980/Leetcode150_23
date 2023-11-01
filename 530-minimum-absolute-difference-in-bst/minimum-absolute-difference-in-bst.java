class Solution {
    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
      helper(root.left);
        min=Math.min(min,Math.abs(root.val-prev));
        prev=root.val;
        
       
        helper(root.right);
    }
}
