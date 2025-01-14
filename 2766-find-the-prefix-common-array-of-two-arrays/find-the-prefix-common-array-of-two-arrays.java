// 123456789
// 987654321
// 0000
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n= A.length;
        int[] freq=new int[n+1];
        
        int[] ans= new int[n];

        int commoncount=0;
      
        for(int i=0; i<n ;i++ ){
            freq[A[i]]++;
            if(freq[A[i]]==2 ){
                commoncount++;
            }
           
            freq[B[i]]++;
             if(freq[B[i]]==2 ){
                commoncount++;
            }

            ans[i]=commoncount;
            
           
        }
        return ans;
    }
}