class Solution {
    public long subArrayRanges(int[] arr) {
          int n = arr.length;
        long totalRange = 0;
        final int MOD = 1000000007; // Modulus value

        // Arrays for NGE, PGE, NSE, PSE
        int[] nge = new int[n];
        int[] pge = new int[n];
        int[] nse = new int[n];
        int[] pse = new int[n];

        // Calculate Next Greater Element (NGE) indices
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek(); // If stack is empty, set to n
            st.push(i);
        }

        // Calculate Previous Greater Element (PGE) indices
        Stack<Integer> st1 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] < arr[i]) {
                st1.pop();
            }
            pge[i] = st1.isEmpty() ? -1 : st1.peek(); // If stack is empty, set to -1
            st1.push(i);
        }

        // Calculate Next Smaller Element (NSE) indices
        st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek(); // If stack is empty, set to n
            st.push(i);
        }

        // Calculate Previous Smaller Element (PSE) indices
        st1 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) {
                st1.pop();
            }
            pse[i] = st1.isEmpty() ? -1 : st1.peek(); // If stack is empty, set to -1
            st1.push(i);
        }

        long sumOfSubarrayMinimums = 0;
        long sumOfSubarrayMaximums = 0;

        for(int i=0;i<n;i++){
            long cnteleleft = i-pse[i];
            long cnteleright = nse[i]-i;
            sumOfSubarrayMinimums+=cnteleleft*cnteleright*arr[i];
        }
        for(int i=0;i<n;i++){
            long cnteleleft = i-pge[i];
            long cnteleright = nge[i]-i;
            sumOfSubarrayMaximums+=cnteleleft*cnteleright*arr[i];
        }

        
       return sumOfSubarrayMaximums-sumOfSubarrayMinimums;
    }
}