class Solution {
    public double power(double x,int n){
         if(n==0) return 1.0;
         double half= power(x,n/2);
            if(n%2==0){
                return half*half;
            }
            else{
                return x*half*half;
            }
    }
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0) return power(1/x,-n);
        return power(x,n);
    }
}
 