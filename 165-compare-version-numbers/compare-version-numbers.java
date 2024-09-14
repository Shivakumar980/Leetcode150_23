class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");

        int len = Math.max(v1.length,v2.length);

        int num1,num2;
        for(int i=0;i<len;i++){
            
            if(i>=v1.length){
                num1=0;
                num2=Integer.valueOf(v2[i]);
            }
            else if(i>=v2.length){
                num2=0;
                num1=Integer.valueOf(v1[i]);
            }
            else{
                num1=Integer.valueOf(v1[i]);
                num2=Integer.valueOf(v2[i]);
            }
            if(num1>num2){
                return 1;
            }
            else if(num2> num1){
                return -1;
            }
            System.out.println(num1);
            System.out.println(num2);

        }

        return 0;

    }
}