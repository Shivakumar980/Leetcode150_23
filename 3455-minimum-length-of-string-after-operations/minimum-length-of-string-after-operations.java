
class Solution {

    
    public int minimumLength(String s) {
        int[]  cmap= new int[26];
        int n=s.length();
        for(int i=0;i<n ;i++){
            int c=s.charAt(i)-'a';
            cmap[c]++;
        }
        int count=0;
        for(int i=0;i<26 ;i++){
            if(cmap[i]!=0 && cmap[i]%2==1){
                count+=1;
            }
            else if(cmap[i]!=0 && cmap[i]%2==0){
                count+=2;
            }
        }
        return count;
        
    }
}