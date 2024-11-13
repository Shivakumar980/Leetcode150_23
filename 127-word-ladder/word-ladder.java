class Pair{
    String word;
    int steps;

    public Pair(String word, int steps){
        this.word=word;
        this.steps=steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = wordList.size();

        HashSet<String> hs= new HashSet<>();

        for (int i=0 ; i<n ;i++){
            hs.add(wordList.get(i));
        }

        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){

            String word=q.peek().word;
            int steps=q.peek().steps;
            q.remove();

            if(word.equals(endWord)) return steps;

            for(int i=0; i < word.length() ;i++){
                char[] replacedCharArray = word.toCharArray();
                for(char ch='a'; ch<='z';ch++){
                    if(replacedCharArray[i]==ch){
                        continue;
                    }
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);
                    if(hs.contains(replacedWord)){
                        hs.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }

        return 0;
    }
}