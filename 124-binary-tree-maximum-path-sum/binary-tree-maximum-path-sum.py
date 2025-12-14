# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        res=[root.val]
        def pathsum(root):
            if root is None:
                return 0
            
            leftMax= max(0, pathsum(root.left))
            rightMax=max(0, pathsum(root.right))

            res[0]= max(leftMax+rightMax+root.val, res[0])

            return root.val+ max(leftMax,rightMax )
        pathsum(root)
        return res[0]