class Solution {

    private void generate(int open, int close, String temp, List<String> ans ){
        if(open==0 && close==0){
            ans.add(temp);
            return;
        }
        if(open>0){
            generate(open-1, close, temp+"(" ,ans);
        }
        if(close>open){
            generate(open, close-1, temp+ ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generate(n, n, "",res);
        return res;
    }
}