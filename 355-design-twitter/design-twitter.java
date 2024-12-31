class Pair{
    int tweetId;
    int tweetSequence;

    public Pair(int id, int seq){
        this.tweetId=id;
        this.tweetSequence=seq;
    }

}

    
    class Twitter {
    List<List<Integer>> adj;
    private static int tweetSequence=1;
    HashMap<Integer, ArrayList<Pair>> hm;


    public Twitter() {
        hm= new HashMap<>();
        adj= new ArrayList<>();
        for(int i=0;i<=500; i++){
            adj.add(new ArrayList<>());
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        hm.putIfAbsent(userId, new ArrayList<>());
        hm.get(userId).add(new Pair(tweetId,tweetSequence++ ));

    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.tweetSequence-b.tweetSequence);
        ArrayList<Pair> pairlist= new ArrayList<>();
        if(hm.containsKey(userId)){
            pairlist.addAll(hm.get(userId));
        }
        
            for(int follower: adj.get(userId)){
                if(hm.containsKey(follower)){
                      pairlist.addAll(hm.get(follower));
                }  
            }    

       

        for(Pair pair: pairlist){
            if(pq.size()<10){
                pq.add( pair);
            }
            else if(pair.tweetSequence > pq.peek().tweetSequence){
                pq.poll();
                pq.add(pair);
            }
        }
        List<Integer> ans= new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().tweetId);
        }
        Collections.reverse(ans);


    return ans;
    }
    
    public void follow(int followerId, int followeeId) {
       
        if (!adj.get(followerId).contains(followeeId)) {
    adj.get(followerId).add(followeeId);
}
    }
    
    public void unfollow(int followerId, int followeeId) {
       if (followerId < adj.size()) {
        adj.get(followerId).remove(Integer.valueOf(followeeId)); // Remove by value, not index
    }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */