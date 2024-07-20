class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> al=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int[] rowa=new int[n];
        int[] cola=new int[m];
        for(int i=0;i<n;i++){
            int minrow=Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                minrow=Math.min(minrow,matrix[i][j]);
                System.out.println(i+" "+j);
            }
            rowa[i]=minrow;
        }
         for(int i=0;i<m;i++){
            int maxrow=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                maxrow=Math.max(maxrow,matrix[j][i]);
                System.out.println(i+" "+j);
            }
            cola[i]=maxrow;
            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rowa[i]==cola[j]){
                    al.add(rowa[i]);
                }
            }
        }
        
    
        return al;
    }
}