class Solution {
    public boolean isPossibleDivide(int[] hand, int groupSize) {

        int n=hand.length;
        if(n % groupSize != 0) return false;
       
        HashMap<Integer, Integer> hm=new HashMap<>();

        for(int card: hand){
            hm.put(card, hm.getOrDefault(card,0)+1);
        }
        Arrays.sort(hand);

        for (int num : hand) {
            if (hm.get(num) > 0) { // If this card is still available
                for (int i = num; i < num + groupSize; i++) {
                    if (hm.getOrDefault(i, 0) == 0) {
                        return false; // Cannot form the required group
                    }
                    hm.put(i, hm.get(i) - 1); // Decrease the count of the current card
                }
            }
        }
        return true;
    }
}