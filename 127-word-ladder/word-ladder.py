class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

        hs=set()
        hs={word for word in wordList}
        
        if beginWord==endWord :
            return 1
        queue= deque()
        queue.append(beginWord)

        level=1
        while queue:
            size=len(queue)
            
            for i in range(size):
                word=queue.popleft();
                for ch in range(len(word)):
                    chArray=list(word)
                    for j in range(ord('a'),ord('z')+1):
                        if(chr(j)==chArray[ch]):
                            continue
                        chArray[ch]=chr(j)
                        newWord= ''.join(chArray)
                        if newWord in hs:
                            if newWord==endWord:
                                return level+1
                            queue.append(newWord)
                            hs.remove(newWord)
            level+=1
        
        return 0


