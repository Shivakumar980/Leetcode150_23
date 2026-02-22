class Solution:
    def trap(self, height: List[int]) -> int:
        
        res=0
        leftmax=0
        rightmax=0
        l=0
        r=len(height)-1

        while l<=r:
            leftmax= max(height[l],leftmax)
            rightmax=max(height[r],rightmax)
            if leftmax<rightmax:
                res+= leftmax-height[l]
                l+=1
            else:
                res+=rightmax-height[r]
                r-=1
            
        return res