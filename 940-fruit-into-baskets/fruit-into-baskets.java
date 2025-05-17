class Solution {
    public int totalFruit(int[] fruits) {
        int n= fruits.length;
        int left=0;
        int right=0;
        HashMap<Integer, Integer> hm= new HashMap<>();
        int maxcount=0;

        while(right<n){
            hm.put(fruits[right], hm.getOrDefault(fruits[right],0)+1);

            while(hm.size()>2){
                int val= hm.get(fruits[left]);
                val=val-1;
                hm.put(fruits[left],val);
                if(val==0){
                    hm.remove(fruits[left]);
                }
                left++;
            }
            
            maxcount= Math.max(right-left+1, maxcount);


            right++;

        }
        return maxcount;
        
    }
}