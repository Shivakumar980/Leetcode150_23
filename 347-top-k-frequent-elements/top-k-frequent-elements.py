class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        freq={}

        for num in nums:
            freq[num]= freq.get(num,0)+1

        heap=[]

        for key,val in freq.items():
            heapq.heappush(heap,(val,key))

            if(len(heap)>k):
                heapq.heappop(heap)
        
        res=[]
        while heap:
            x,y = heapq.heappop(heap)
            res.append(y)
        
        return res
