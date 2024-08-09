class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        String pre="";
        String res="";
        for(int i=0;i<=strs[0].length();i++){
            pre=strs[0].substring(0,i);
            System.out.println(pre);
            for(int j=1;j<strs.length;j++){
                if(!strs[j].startsWith(pre)){
                    return res;
                }
            }
            res=pre;
        }
        return res;
    }
}