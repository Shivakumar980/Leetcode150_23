class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        frequencyMap=[0]*26

        for task in tasks:
            frequencyMap[ord(task)-ord('A')]+=1
        

        heap=[ - count for count in frequencyMap if count>0 ]

        heapq.heapify(heap)

        cooldown= deque()

        time=0
        while heap or cooldown:
            time+=1
            if heap:
                count=heapq.heappop(heap);
                count+=1
                if count<0:
                    cooldown.append((count,time+n))
            if cooldown and cooldown[0][1]==time:
                remaining_count,_ = cooldown.popleft()
                heapq.heappush(heap, remaining_count)
        
        return time


