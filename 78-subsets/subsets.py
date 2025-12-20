class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]

        def dfs(index, temp):

            if index==len(nums):
                res.append(temp.copy())
                return
            temp.append(nums[index])
            dfs(index+1, temp)
            temp.remove(nums[index])
            dfs(index+1, temp)
        dfs(0,[])
        return res