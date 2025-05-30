class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n= intervals.length;

        int[] start= new int[n];
        int[] end= new int[n];
        for(int i=0 ; i< n ;i++){
            start[i]=intervals[i][0];
            end[i]= intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s=0; 
        int e=0;
        int rooms=0;
        int res=0;
        while(s<n){
            if(start[s]<end[e]){
                rooms++;
                s++;
            }   
            else{
                rooms--;
                e++;
            }
            res=Math.max(res, rooms);
        }

        return res;
    }
}