class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordset= set(wordList)
        if endWord not in wordset:
             return 0
        if beginWord==endWord:
             return 1

        q=deque()
        q.append(beginWord)
        steps=1

        while q:
            
            for _ in range(len(q)):
                curr= q.popleft()
                if curr==endWord:
                     return steps
                chArray= list(curr)
               

                for i,ch in enumerate(chArray):
                    original =chArray[i]
                    for letter in range(ord('a'), ord('z')+1):
                        chArray[i]=chr(letter)
                        if letter== original:
                            continue
                        currString= "".join(chArray)
                        if currString in wordset:
                            wordset.remove(currString)
                            q.append(currString)
                    chArray[i]=original
                
            steps+=1
        return 0
                        


