class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        int n1= s1.length();
        int n2= s2.length();

        if(n1!=n2) return false;

        int count=0;
        HashSet<Character>  hs1= new HashSet<>();
        HashSet<Character>  hs2= new HashSet<>();
        for(int i=0; i<n1 ;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                hs1.add(s1.charAt(i));
                hs2.add(s2.charAt(i));
            }
        }
        if(!hs1.equals(hs2)) return false;
        
        return count==2 || count==0;
    }
}