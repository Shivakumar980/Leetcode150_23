class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");

        int len = Math.max(v1.length,v2.length);

        int num1,num2;
        for(int i=0;i<len;i++){
            
            num1=(i>=v1.length)? 0 : Integer.valueOf(v1[i]);
            num2=(i>=v2.length)? 0 : Integer.valueOf(v2[i]);

            
            if(num1>num2){
                return 1;
            }
            else if(num2> num1){
                return -1;
            }
            
        }

        return 0;

    }
}