class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] shiftArray=new int[n];
        int m= shifts.length;

        for(int[] shift: shifts){
            int start= shift[0];
            int end= shift[1];
            int direction = shift[2];

            if(direction==1){
                shiftArray[start]++;
                if(end+1<n){
                shiftArray[end+1]--;
                }
            }
            else if(direction==0){
                shiftArray[start]--;
                if(end+1<n){
                shiftArray[end+1]++;
                }
            }
            

        }

        for(int i=1;i<n ;i++){
            shiftArray[i]+=shiftArray[i-1];
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int shift = shiftArray[i] % 26; 
            if (shift < 0) {
                shift += 26;
            }
            sb.append((char)( 'a' +(s.charAt(i)-'a'+shift) %26));
        }
        
        return sb.toString();
    }
}