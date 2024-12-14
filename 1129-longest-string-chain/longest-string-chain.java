class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        
        int[] dist=new int[n];
        Arrays.fill(dist,1);

        int maxlen=1;
        for(int ind=1;ind<n;ind++){
            for(int prev=0; prev<ind ;prev++){
                if( check(words[ind],words[prev]) && 1+dist[prev]>dist[ind]){
                    dist[ind]=1+ dist[prev];
                    maxlen=Math.max(dist[ind],maxlen);
                }
            }
        }
        return maxlen;
        
    }
    private boolean check(String s1, String s2){
        if(s1.length()-1!=s2.length()){
            return false;
        }

        int first=0;
        int second=0;

        while(first<s1.length() ){
            if( second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        return first==s1.length() && second==s2.length();
    }
}