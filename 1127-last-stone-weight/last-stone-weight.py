class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap=[]

        for stone in stones:
            heapq.heappush(heap, -1*stone)
        
        while len(heap)>1:
            first= heapq.heappop(heap)
            second=heapq.heappop(heap)
            if first!=second:
                heapq.heappush(heap,-1 * abs(abs(first)-abs(second)))
        
        return 0 if not heap else -1*heap[0]