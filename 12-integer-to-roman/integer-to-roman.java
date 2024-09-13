class Solution {
    public String intToRoman(int num) {
        
        String[] romanArray={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] intArray={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb=new StringBuilder();
        
     
        for(int i=0;i<intArray.length;i++){
            while(num>=intArray[i]){
                sb.append(romanArray[i]);
                num-=intArray[i];
            }
        }
        return sb.toString();
    }
}

//3000
//3749