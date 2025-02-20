class Solution {
    int n;
    Set<String> numSet = new HashSet();

    private String generate(String curr){
        if(curr.length() == n ){
            if(!numSet.contains(curr)){
                return curr;
            }

            return "";
        }

        String addZero = generate(curr + "0");
        if(addZero.length()>0){
            return addZero;
        }
        return generate(curr + "1");
    }

    public String findDifferentBinaryString(String[] nums) {
        n= nums.length;
        for(String s: nums){
            numSet.add(s);
        }
        return generate("");
    }
}