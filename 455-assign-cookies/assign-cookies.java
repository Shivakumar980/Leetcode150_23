class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gindex=0;
        int count=0;
        for(int i=0 ;i<s.length;i++){
            if(g[gindex]<=s[i]){
                count++;
                gindex++;
            }
            if(gindex==g.length) break;
        }
        
        return count;
    }
}