# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        self.flag= True
        def height(root):
            if root is None:
                return 0
                
            lh= height(root.left)
            rh= height(root.right)
            if abs(lh-rh)>1:
                self.flag= False
            return 1+ max(lh , rh)
        
        height(root)
        return self.flag
        
        