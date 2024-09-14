class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeatCount=1;
        StringBuilder repeatString=new StringBuilder(a);
        while(repeatString.length()<b.length()){
            repeatString.append(a);
            repeatCount++;
        }
        if(repeatString.toString().contains(b)){
            return repeatCount;
        }
        repeatString.append(a);
        if(repeatString.toString().contains(b)){
            return repeatCount+1;
        }

        return -1;
    }
}