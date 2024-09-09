class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        int n=parts.length;
        for(int i=0;i<n/2;i++){
            String temp=parts[i];
            parts[i]=parts[n-1-i];
            parts[n-1-i]=temp;
        }
       for(int i=0;i<n;i++){
        if(parts[i]!=""){
            sb.append(parts[i]);
        }
        
        if(i<n-1){
            sb.append(" ");
        }
       
    }
     return sb.toString();
}
}