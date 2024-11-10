class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int k=3;
        return helper(s,3)-helper(s,2);
    }
    int helper(String s, int k){
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            // Add character at `right` to the map
            hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);

            // Shrink window if we exceed `k` distinct characters
            while (hm.size() > k) {
                char leftChar = s.charAt(left);
                hm.put(leftChar, hm.get(leftChar) - 1);
                if (hm.get(leftChar) == 0) {
                    hm.remove(leftChar);
                }
                left++;
            }

            // Count all valid substrings ending at `right`
            if(hm.size()<=k){
               count += (right - left + 1);
            }
        }
        return count;
    }
}