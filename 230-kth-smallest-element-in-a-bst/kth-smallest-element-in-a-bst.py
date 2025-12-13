# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.res=[]
        def inOrder(root,k):
            if root is None:
                return
           
            inOrder(root.left,k)
            self.res.append(root.val)  
            inOrder(root.right,k)

        inOrder(root,k)
        return self.res[k-1]