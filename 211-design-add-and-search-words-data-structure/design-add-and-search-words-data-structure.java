class TrieNode{
    boolean endOfWord=false;
    HashMap<Character, TrieNode> children= new HashMap<>();
}
    
    
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root= new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr= root;
        for(char c: word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr=curr.children.get(c);
        }
        curr.endOfWord=true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0 ,root);
        
    }
    private boolean dfs(String word, int j, TrieNode curr){
        for(int i=j ; i< word.length() ; i++){
            char c= word.charAt(i);
            if(c=='.'){
                for(TrieNode child: curr.children.values()){
                   if(dfs(word, i+1,child)){
                    return true;
                   }
                }
                return false;
            }
            else{
                if(!curr.children.containsKey(c)){
                    return false;
                }
                curr=curr.children.get(c);
            }
        }
        return curr.endOfWord;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */