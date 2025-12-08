class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        adj= defaultdict(list)

        for x, y in prerequisites:
            adj[y].append(x)
        
        indegree= [0]*numCourses

        for first, second in prerequisites:
            indegree[first]+=1
        
        q= deque()

        for i, val in enumerate(indegree):
            if val==0:
                q.append(i)
        

        count=0
        while q:
            node= q.popleft()
            count+=1

            for neighbor in adj[node]:
                indegree[neighbor]-=1
                if(indegree[neighbor]==0):
                    q.append(neighbor)
        return count==numCourses
                

                