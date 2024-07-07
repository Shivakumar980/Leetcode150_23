class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=0;
       sum+=numBottles;
        while(numBottles>=numExchange){

            int extra=numBottles%numExchange;
            int div=numBottles/numExchange;
            sum+=div;
            numBottles=div+extra;
        }
        return sum;
    }
}