class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()< Math.abs(asteroids[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])){
                    st.pop();
                    continue;
                }
                else if(st.isEmpty()|| st.peek()<0){
                    st.add(asteroids[i]);
                }


            }
           
            
        }
        int m=st.size();
         int[] ans=new int[m];
        
            for(int i=m-1 ;i>=0 ;i--){
                ans[i]=st.pop();
            }

            return ans;
    }

}