class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        n=len(intervals)
        result=[]
        i=0
        while i<n and intervals[i][1]<newInterval[0]:
            result.append(intervals[i])
            i+=1
        
        mergeStart= newInterval[0]
        mergeEnd= newInterval[1]

        while i<n and intervals[i][0]<=mergeEnd:
            mergeStart= min(mergeStart,intervals[i][0])
            mergeEnd= max(mergeEnd, intervals[i][1])
            i+=1
        result.append([mergeStart,mergeEnd])

        while(i<n):
            result.append(intervals[i])
            i+=1
        return result


        