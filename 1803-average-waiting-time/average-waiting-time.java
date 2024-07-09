class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n=customers.length;
        double[] finish=new double[customers.length];

        finish[0]=customers[0][0]+customers[0][1];
        for(int i=1;i<n;i++){
            if(customers[i][0]<=finish[i-1]){
                finish[i]=finish[i-1]+customers[i][1];
            }
            else{
                finish[i]=customers[i][0]+customers[i][1];
            }
        }
        double sum=0;
        for(int i=0;i<n;i++){
            sum+=finish[i]-customers[i][0];
        }
        return sum/n;
    }
}