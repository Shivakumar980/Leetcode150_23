class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        n= len(intervals)
        intervals.sort(key=lambda x:x[1])
        
        prevEnd=intervals[0][1]
        result=0
        for i in range(1,n):
            if intervals[i][0]>= prevEnd :
                prevEnd=intervals[i][1]
            else:
                result+=1
                prevEnd=min(prevEnd, intervals[i][1])
        
        return result



        
        