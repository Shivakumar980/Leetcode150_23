class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1=s1.length();
        int n2=s2.length();

        if(n1>n2) return false;

        int[] freq_s1=new int[26];
        int[] freq_s2=new int[26];

        for(int i=0; i< n1; i++){
            freq_s1[s1.charAt(i)-'a']++;
            freq_s2[s2.charAt(i)-'a']++;
        }

        int matches=0;

        for(int i=0; i<26 ;i++){
            if(freq_s1[i]==freq_s2[i]){
                matches++;
            }
        }

        int left=0;
        int right=n1;

        while(right<n2){
            if(matches==26){
                return true;
            }

            freq_s2[s2.charAt(right)-'a']++;
            if(freq_s2[s2.charAt(right)-'a']==freq_s1[s2.charAt(right)-'a']){
                matches++;
            }
            else if(freq_s2[s2.charAt(right)-'a']-1==freq_s1[s2.charAt(right)-'a']){
                matches--;
            }

            freq_s2[s2.charAt(left)-'a']--;
            if(freq_s2[s2.charAt(left)-'a']==freq_s1[s2.charAt(left)-'a']){
                matches++;
            }
            else if(freq_s2[s2.charAt(left)-'a']+1== freq_s1[s2.charAt(left)-'a']){
                matches--;
            }
            right++;
            left++;
        }
        return matches==26;
        
    }
}