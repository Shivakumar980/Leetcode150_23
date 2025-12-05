class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map={}
        sum=0
        for ind, num in enumerate(nums):
            sum= target-num
            if sum  in map:
                return [ind, map[sum]]
            map[num]=ind
        return [-1,-1]

        