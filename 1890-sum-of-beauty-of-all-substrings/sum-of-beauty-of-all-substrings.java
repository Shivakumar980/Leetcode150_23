class Solution {
    public int beautySum(String s) {
        int n= s.length();
        int count=0;
        for(int i=0 ;i<n ; i++){
            int[] cmap= new int[26];

           
            for(int j=i ; j< n ;j++){
                int min= Integer.MAX_VALUE;
                int max= Integer.MIN_VALUE;
                cmap[s.charAt(j)-'a']++;
                for(int k=0 ;k <=25; k++){
                    if(cmap[k]>0){
                        min= Math.min(cmap[k], min);
                        max= Math.max(cmap[k], max);
                    }
                  
                }
                 count+= (max-min);
                
            }
            
           

        }

        return count;
    }
}