class Solution {

    private void generate(int open, int close, String temp, List<String> ans, int n ){
        if(open==n && close==n){
            ans.add(temp);
            return;
        }
        if(open<n){
            generate(open+1, close, temp+"(" ,ans, n);
        }
        if(close<open){
            generate(open, close+1, temp+ ")", ans, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generate(0, 0, "",res, n);
        return res;
    }
}