# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.res= None
        self.k=k
        def inOrder(root,k):
            if root is None or self.res is not None:
                return
           
            inOrder(root.left,k)
            if self.res is not None:
                 return 
            self.k-=1
            if self.k==0:
                self.res= root.val
                return
            inOrder(root.right,k)

        inOrder(root,k)
        return self.res