# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:

      
        self.res=[]
        def countGood(root,maxi):
            if root is None:
                return 
            if root.val>= maxi :
                self.res.append(root)
            maxi=max(root.val,maxi)
            countGood(root.left, maxi)
            countGood(root.right, maxi)
        countGood(root,float('-inf'))
        return len(self.res)
        

            

        