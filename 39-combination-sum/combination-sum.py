class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res=[]

        def dfs(index, target, temp):
            if target==0:
                res.append(temp.copy())
                return
            if index==len(candidates) or target<0:
                return
            
            temp.append(candidates[index])
            dfs(index,target-candidates[index],temp)
            temp.remove(candidates[index])
            dfs(index+1,target, temp)
        dfs(0,target, [])

        return res

        