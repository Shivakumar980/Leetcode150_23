class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ind=n-k+1;
        int[] res= new int[ind];
        int index=0;
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
              // Remove elements out of the current window
            if(!q.isEmpty() && q.peekFirst()<i-k+1) q.pollFirst();
            // Remove elements from the back that are smaller than the current element
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1){
                res[index++]=nums[q.peekFirst()];
            }
            
       
        }
         return res;
    }
       
}