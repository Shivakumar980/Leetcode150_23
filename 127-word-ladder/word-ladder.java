class Pair{
    String word;
    int steps;

    public Pair(String word, int steps){
        this.word= word;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> wordSet= new HashSet<>();
        for(String s: wordList){
            wordSet.add(s);
        }

        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            String word= q.peek().word;
            int steps= q.peek().steps;
            q.remove();
            if(word.equals(endWord)) return steps;

            for(int i=0 ; i< word.length(); i++){
                char[] tempArray= word.toCharArray();

                for(char c='a'; c<='z'; c++){
                   
                    if(tempArray[i]==c){
                        continue;
                    }
                    tempArray[i]=c;
                    String tempword= new String(tempArray);
                    if(wordSet.contains(tempword)){
                        wordSet.remove(tempword);
                        q.offer(new Pair(tempword,steps+1));
                    }
                }
            }

        }
        return 0;
    }
}