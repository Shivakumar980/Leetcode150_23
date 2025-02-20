class Solution {
    int n;
    Set<String> numSet= new HashSet<>();

    private String generate(String curr){
        if(curr.length()==n){
            if(!numSet.contains(curr)){
                return curr;
            }
            return "";
        }

        String strlength= generate(curr +"0");
        if(strlength.length() >0){
            return strlength;
        }

        return generate(curr + "1");
    }


    public String findDifferentBinaryString(String[] nums) {
         n= nums.length;

        for(String num:nums){
            numSet.add(num);
        }

        return generate("");
    }
}