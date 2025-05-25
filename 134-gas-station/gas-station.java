class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n=gas.length;

        int sum_gas=0;
        int sum_cost=0;
        for(int i=0 ;i< n; i++){
            sum_gas+=gas[i];
            sum_cost+=cost[i];
        }
        if(sum_cost-sum_gas> 0) return -1;

        int total=0;
        int res=0;
        for(int i=0; i< n ;i++){

            total+= (gas[i]-cost[i]);
            if(total<0){
                total=0;
                res=i+1;
            }

        }
        return res;
        
    }
}