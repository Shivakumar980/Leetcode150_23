class Solution {
    //2,2,4
    //1,2,2,
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);
        int gindex=0;
        int sindex=0;
        int count=0;
        while(gindex<g.length && sindex<s.length){
            if(g[gindex]<=s[sindex]){
                count++;
                gindex++;
                
            }
           
                sindex++;
            
        }
        return count;

        
    }
}