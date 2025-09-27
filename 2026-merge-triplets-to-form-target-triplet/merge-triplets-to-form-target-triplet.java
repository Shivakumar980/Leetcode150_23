class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n= triplets.length;

        int[] count=new int[3];
        for(int[] triplet : triplets){

            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){
                if(triplet[0]==target[0]){
                    count[0]++;
                }
                if(triplet[1]==target[1]){
                    count[1]++;
                }
                if(triplet[2]==target[2]){
                    count[2]++;
                }
            }
            
        }
        for(int num:count){
            if(num<1){
                return false;
            }
        }
        return true;
    }
}