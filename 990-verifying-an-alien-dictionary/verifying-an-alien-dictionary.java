class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        HashMap<Character, Integer> cmap= new HashMap<>();

        int index=0;
        for(char c: order.toCharArray()){
            cmap.put(c, index++);
        }

        for(int i=0; i< words.length-1; i++){

                String word1= words[i];
                String word2= words[i+1];

                int s1= word1.length();
                int s2= word2.length();

                boolean compared=false;

                for(int k=0; k<Math.min(s1,s2) ;k++){
                    char firstChar=word1.charAt(k);
                    char secondChar= word2.charAt(k);
                    if(firstChar!= secondChar){
                        if((cmap.get(firstChar)>cmap.get(secondChar))){
                            return false;
                        }
                        compared = true;  // Found a difference, no need to check further
                        break;
        
                    }
                    
                }
                if(s1>s2 && word1.startsWith(word2)) return false;

        }
        
        return true;
        
    }
}