class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total_surplus,surplus=0,0
        start=0
        n=len(gas)
        for i in range(0,n):
            gain=gas[i]-cost[i]
            total_surplus+=gain
            surplus+=gain

            if(surplus<0):
                surplus=0
                start=i+1
        
        return -1 if total_surplus<0 else start

