class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res=[]
        def dfs(index, curr, sum):
            if sum > target  or index >= len(candidates):
                return
            if sum==target:
                res.append(curr.copy())
                return
            curr.append(candidates[index])
            dfs(index, curr, sum+ candidates[index])
            curr.pop()
            dfs(index+1, curr, sum)

        dfs(0, [], 0)
        return res
