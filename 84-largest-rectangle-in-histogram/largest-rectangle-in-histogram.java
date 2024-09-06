class Pair{
    int key;
    int val;
    public Pair(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int MaxArea=0;
        int n=heights.length;
        int start;
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<n;i++){
            int currHt=heights[i];
            start=i;
            while(!st.isEmpty() && st.peek().val>currHt){
                Pair pair=st.pop();
                int index=pair.key;
                int ht=pair.val;
                MaxArea=Math.max(MaxArea,ht*(i-index));
                start=index;
            }
            st.push(new Pair(start,currHt));
        }
        while(!st.isEmpty()){
            Pair pair=st.pop();
            int index=pair.key;
            int ht=pair.val;
            MaxArea=Math.max(MaxArea, ht*(n-index));
        }
        return MaxArea;
    }
}