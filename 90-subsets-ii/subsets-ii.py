class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        res=[]

        def backtrack(index, comb):
            if index==len(nums):
                res.append(comb.copy())  
                return    
            comb.append(nums[index])
            backtrack(index+1, comb)
            comb.pop()
            while index+1 < len(nums) and nums[index]==nums[index+1]:
                index+=1
            backtrack(index+1,comb)
        backtrack(0,[])
        return res