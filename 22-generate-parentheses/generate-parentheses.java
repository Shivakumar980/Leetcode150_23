class Solution {

    private void generate(int open, int close, int n,String part, List<String> result){
        if(open==n && close==n){
            result.add(part);
        }
        if(open<n){
            
            generate(open+1, close, n , part+ "(",result);
        }
        if(close<open){
           
            generate(open, close+1, n , part + ")",result);
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
         generate(0, 0, n ,"", result);
         return result;
    }
}