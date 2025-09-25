class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result= []
        n= len(intervals)
        intervals.sort(key=lambda  x:x[0])
        mergeStart= intervals[0][0]
        mergeEnd= intervals[0][1]

        for i in range(1,n):
            if intervals[i][0]<=mergeEnd:
                mergeEnd= max(mergeEnd, intervals[i][1]);
            
            else:
                result.append([mergeStart,mergeEnd]);
                mergeStart= intervals[i][0];
                mergeEnd=intervals[i][1]
        result.append([mergeStart,mergeEnd]);

        return result