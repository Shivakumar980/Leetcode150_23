class Solution:
    def jump(self, nums: List[int]) -> int:

        n= len(nums)
        left,right=0,0
        steps=0

        while(right<n-1):
            farthest=0
            for i in range(left,right+1):
                farthest=max(farthest,i+nums[i])
            left=right+1
            right=farthest
            steps+=1
        
        return steps
        
        