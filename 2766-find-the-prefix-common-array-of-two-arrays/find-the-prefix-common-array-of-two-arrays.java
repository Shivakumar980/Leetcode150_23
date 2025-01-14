// 123456789
// 987654321
// 0000
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n= A.length;
        int[] freq=new int[51];
        freq[A[0]]++;
        freq[B[0]]++;
        int[] ans= new int[n];
        if(freq[B[0]]==2){
               ans[0]=1; 
        }


      
        for(int i=1; i<n ;i++ ){
            freq[A[i]]++;
           
            freq[B[i]]++;

            
            if(freq[A[i]]==2 && freq[B[i]]==2 && A[i]==B[i]){
                ans[i]+=ans[i-1]+1;
            }
            else if(freq[A[i]]==2 && freq[B[i]]==2){
                ans[i]=ans[i-1]+2;
            }
            else if(freq[A[i]]==2 || freq[B[i]]==2){
                ans[i]=ans[i-1]+1;
            }
            else{
                ans[i]=ans[i-1];
            }
            
           
        }
        return ans;
    }
}