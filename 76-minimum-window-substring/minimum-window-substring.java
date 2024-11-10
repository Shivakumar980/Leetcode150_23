class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int left=0;
        int right=0;
        int maxlen=Integer.MAX_VALUE;
        String ans="";
        int[] freqMap=new int[256];
        StringBuilder sb=new StringBuilder();
        int m=t.length();
        int count=0;
        for(int i=0;i<m;i++){
            freqMap[t.charAt(i)]++;
        }

        while(right < n){
            if(freqMap[s.charAt(right)]>0){
                 count++;
            }
           freqMap[s.charAt(right)]--;
           
            while(count==m){
                if(right-left+1<maxlen){
                    maxlen=right-left+1;
                    ans=s.substring(left,right+1);
                }
                freqMap[s.charAt(left)]++;
                if(freqMap[s.charAt(left)]>0){
                    count--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}