class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    int helper(int[] s, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = s.length;
        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            // Add character at `right` to the map
            hm.put(s[right], hm.getOrDefault(s[right], 0) + 1);

            // Shrink window if we exceed `k` distinct characters
            while (hm.size() > k) {
                int leftChar = s[left];
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