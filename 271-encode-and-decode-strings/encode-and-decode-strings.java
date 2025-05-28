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
        int n= s.length();

        List<String> res= new ArrayList<>();
        int left=0;
        int right=0;
        while(right< n) {
            char ch= s.charAt(right);
            if( ch=='#'){
                int len= Integer.valueOf(s.substring(left,right));
                String str= s.substring(right+1,right+len+1);
                res.add(str);
                right=right+len+1;
                left=right;
            }else{
                  right++;
            }
          

        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));