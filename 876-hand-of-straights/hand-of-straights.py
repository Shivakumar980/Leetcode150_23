class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        n= len(hand)
        frequencyMap=Counter(hand)

        for card in sorted(frequencyMap):
            while(frequencyMap[card]>0):
                for i in range(0,groupSize):
                    if(frequencyMap[i+card]==0):
                        return False;
                    else:
                        frequencyMap[i+card]-=1
        return True