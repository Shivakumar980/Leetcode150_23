class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res=set()

        def dfs(index, target, temp):
            if target==0:
                res.add(tuple(temp))
                return
            if index==len(candidates) or target<0:
                return
            
            temp.append(candidates[index])
            dfs(index+1,target-candidates[index],temp)
            temp.pop()
            while index+1<len(candidates) and candidates[index]==candidates[index+1]:
                index+=1
            dfs(index+1,target, temp)
        dfs(0,target, [])

        return [ list(t) for t in res]
