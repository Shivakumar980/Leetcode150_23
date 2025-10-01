class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map=Counter(nums)

        heap=[]
        for key, val in map.items():
     
            heapq.heappush(heap,(val,key))

            if(len(heap)>k):
                heapq.heappop(heap)
        result=[]
        while heap:
            val=heapq.heappop(heap)[1]
            result.append(val)
        return result

