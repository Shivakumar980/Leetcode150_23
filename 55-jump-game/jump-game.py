class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n= len(nums)
        last_index=n-1
        for i in range(n-2,-1,-1):
            if nums[i]>=last_index-i:
                last_index=i
            
        return last_index==0