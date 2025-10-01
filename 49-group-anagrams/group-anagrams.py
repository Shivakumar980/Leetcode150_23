class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        n=len(strs)
        map={}
        for s in strs:
            key=tuple(sorted(s))
            if key in map:
                map[key].append(s)
            else:
                map[key]=[s]
        result=[]

        for key, value in map.items():
            result.append(value)
        return result