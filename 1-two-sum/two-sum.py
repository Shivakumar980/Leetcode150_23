class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map={}
        n=len(nums)
        
        for i in range(0, n):
            sum=0
            sum=target-nums[i]

            if sum in map:
                return [map[sum],i]
            map[nums[i]]=i
        return []