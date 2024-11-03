class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        ArrayList<Integer> st=new ArrayList<>();
        int n=asteroids.length;
        
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.add(asteroids[i]);
            }
            else{
                while(st.size()!=0 && st.get(st.size()-1)>0 && st.get(st.size()-1)< Math.abs(asteroids[i])){
                    st.remove(st.size()-1);
                }
                if(st.size()!=0 && st.get(st.size()-1)==Math.abs(asteroids[i])){
                    st.remove(st.size()-1);
                    continue;
                }
                else if(st.size()==0 || st.get(st.size()-1)<0){
                    st.add(asteroids[i]);
                }


            }
           
            
        }
         int[] ans=new int[st.size()];
            int ind=0;
            for(int num:st){
                ans[ind++]=num;
            }

            return ans;
    }

}