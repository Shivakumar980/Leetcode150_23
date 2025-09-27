class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        map={ s[i]:i for i in range(0,len(s)) }

        end=0
        size=0
        result=[]
        for i in range(0, len(s)):
            size+=1
            end= max(end, map[s[i]])
            if(end==i):
                result.append(size)
                size=0
        return result
