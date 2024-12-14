class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int n=nums.length;
    
    List<Integer> ans= new ArrayList<>();
    if( n==0) return ans;
    int[] dist= new int[n];
    Arrays.fill(dist,1);
    int[] hash= new int[n];
    for(int i=0;i<n;i++){
        hash[i]=i;
    }

    int index=0;
    int maxval=1;
    for(int ind =1; ind<n ;ind++){
        for(int prev=0; prev<ind ; prev++){
            if(nums[ind]%nums[prev]==0 && 1+dist[prev]>dist[ind]){
                dist[ind]=1+dist[prev];
                hash[ind]=prev;
            }
        }
        if(dist[ind]>maxval){
            maxval=dist[ind];
            index=ind;
        }
    }

    while(hash[index]!=index){
        ans.add(nums[index]);
        index=hash[index];
    }
    ans.add(nums[index]);
    Collections.reverse(ans);
    return ans;
    }
}