class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        ArrayList<Integer> al=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n1;i++){
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<n2;i++){
            if(hm.containsKey(nums2[i]) && hm.get(nums2[i])>0){
                al.add(nums2[i]);
                hm.put(nums2[i],hm.get(nums2[i])-1);
            }
            
        }
        int size=al.size();
        int[] resArray=new int[size];
        for(int i=0;i<size;i++){
            resArray[i]=al.get(i);
        }
        return resArray;
    }
}