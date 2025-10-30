class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> hs= new HashSet<>(wordList);
        if(beginWord.equals(endWord)) return 1;
        Queue<String> q= new LinkedList<>();
        q.offer(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int length=0; length< size ; length++){
                String word= q.poll();;
                for(int i=0 ; i< word.length(); i++){
                char[] chArray= word.toCharArray();
                    for(char j='a'; j<='z'; j++){
                        if(j==chArray[i]) continue;
                        chArray[i]=j;
                        String newWord= new String(chArray);
                        if(hs.contains(newWord)){
                            if(newWord.equals(endWord)) return level+1;
                            System.out.println(newWord);
                            q.offer(newWord);
                            hs.remove(newWord);
                             }
                        }
        
                    }
             
            }
            level++;
            
        }
        return 0;
    }
}