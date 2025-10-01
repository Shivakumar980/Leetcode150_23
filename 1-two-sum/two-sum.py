class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map={}
        n=len(nums)
        
        for i,num in enumerate(nums):
            sum=target-num

            if sum in map:
                return [map[sum],i]
            map[num]=i
        return []