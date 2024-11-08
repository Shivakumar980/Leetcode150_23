class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            int[] freqMap=new int[26];
            for(int j=i;j<n;j++){
                int index=s.charAt(j)-'a';
                freqMap[index]++;
                int minval=Integer.MAX_VALUE;
                int maxval=Integer.MIN_VALUE;
                for(int k=0;k<26;k++){
                    if(freqMap[k]>0){
                        minval=Math.min(minval,freqMap[k]);
                        maxval=Math.max(maxval,freqMap[k]);
                    }
                }
                count+=(maxval-minval);

            }
        }
        return count;
    }
}