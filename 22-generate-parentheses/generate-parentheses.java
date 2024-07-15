class Solution {
    
    private void genHelper(int open, int close, String st, List<String> ans) {
        if (open == 0 && close == 0) {
            ans.add(st);
            return;
        }
        
        if (open > 0) {
            genHelper(open - 1, close, st + "(", ans);
        }
        
        if (close > open) {
            genHelper(open, close - 1, st + ")", ans);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        genHelper(n, n, "", ans);
        return ans;
    }
}