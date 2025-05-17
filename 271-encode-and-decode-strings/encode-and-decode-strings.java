public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb= new StringBuilder() ;
        for(String str: strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
        
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int n= s.length();
       
        List<String> ans= new ArrayList<>();
        int i=0;

        while(i<n){
            int j=i;
            while(s.charAt(j)!='#'){
                j++;
            }
            int length= Integer.valueOf(s.substring(i, j));
            String res=s.substring(j+1,j+length+1);
            ans.add(res);
            i=j+length+1;

            }
        
        return ans;
        
    }
}
//5#Hello5#World2#is4#mine


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));