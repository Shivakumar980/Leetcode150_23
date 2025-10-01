class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hs=set()
        n=len(nums)
        for num in nums:
            if num in hs:
                return True
            hs.add(num)
        return False