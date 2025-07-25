public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb= new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res= new ArrayList<>();
        int left=0;
        int right=0;
        int n= s.length();
        while(right<n){
            if(s.charAt(right)=='#'){
                int len= Integer.valueOf(s.substring(left,right));
                String part=s.substring(right+1, right+1+len);
                res.add(part);
                right=right+1+len;
                left=right;
            }
            else{
                right++;
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));