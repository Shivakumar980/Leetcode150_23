public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb= new StringBuilder();

        for(String s: strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int n=s.length();
        List<String> ans= new ArrayList<>();
        int left=0;
        int right=0;
        while(right<n){
            if(s.charAt(right)=='#'){
                int len= Integer.valueOf(s.substring(left,right));
                String st=s.substring(right+1, right+len+1);
                ans.add(st);
                right=right+len+1;
                left=right;
            }
            else{
                right++;
            }

            
        }

     return ans;
    }

}
//#10aaaaaaaaaa#3abc
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));