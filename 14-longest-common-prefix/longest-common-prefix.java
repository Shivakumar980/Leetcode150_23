class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int lenMin=300;
        for(String str:strs){
            lenMin=Math.min(str.length(),lenMin);
        }
        String res="";
        for(int i=0;i<lenMin;i++){
            for(int j=1;j<strs.length;j++){
                if(!strs[j].substring(0,i+1).equals(strs[j-1].substring(0,i+1))){
                    return res;
                }  
            }
                res=strs[0].substring(0,i+1);
        }
        return res;
    }
}