class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n=arr.length;
        int[] nse=new int[n];
        int[] pse=new int[n];
        long total=0;
        int MOD = 1000000007;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0 ;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
           nse[i]= st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        Stack<Integer> st1=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st1.isEmpty() && arr[st1.peek()]> arr[i]){
                st1.pop();
            }
            pse[i]=st1.isEmpty() ? -1: st1.peek();
            st1.push(i);
        }

        for(int i=0;i<n;i++){
           total = (total + (long)(nse[i] - i) * (i - pse[i]) % MOD * arr[i] % MOD) % MOD;
        }

        return (int)total;
    }
}