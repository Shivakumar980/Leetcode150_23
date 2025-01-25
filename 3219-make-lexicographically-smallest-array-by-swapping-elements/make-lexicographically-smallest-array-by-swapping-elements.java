class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);

        int n=nums.length;
        
        List<Queue<Integer>> qlist=new ArrayList<>();
        HashMap<Integer , Integer> hm= new HashMap<>();

        int groupNumber=0;
        Queue<Integer> q1= new LinkedList<>();
        q1.add(sortedArray[0]);
        qlist.add(q1);
        hm.put(sortedArray[0],groupNumber);
        for(int i=1; i<n ;i++){
            if(Math.abs(sortedArray[i]-sortedArray[i-1])<=limit){
                qlist.get(groupNumber).add(sortedArray[i]);
                hm.put(sortedArray[i],groupNumber);
            }
            else{
                Queue<Integer> q= new LinkedList<>();
                q.add(sortedArray[i]);
                qlist.add(q);
                groupNumber++;
                hm.put(sortedArray[i],groupNumber );
            }
        }

        for(int i=0; i<n ;i++){
           if (hm.containsKey(nums[i])) {
                int index = hm.get(nums[i]);
                nums[i] = qlist.get(index).poll(); // Poll from the corresponding queue
            } 
            
        }

        return nums;

    }
}