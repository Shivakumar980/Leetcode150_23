class Solution {
    public String alienOrder(String[] words) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0 ; i<26; i++){
            adj.add(new ArrayList<>());
        }
        int n= words.length;

        boolean[] seen= new boolean[26];
        for(String word: words){
            for(char c: word.toCharArray()){
                seen[c-'a']=true;
            }
        }

        for(int i=0 ; i< n-1; i++){
            String s1=words[i];
            String s2=words[i+1];

            int l1= s1.length();
            int l2= s2.length();

            if(s1.length()> s2.length() && s1.startsWith(s2)){
                return "";
            }

            for(int j=0 ; j< Math.min(l1,l2); j++){
                char c1= s1.charAt(j);
                char c2= s2.charAt(j);
                if(c1!=c2){
                    adj.get(c1-'a').add(c2-'a');
                    break;
                }
                else{
                    continue;
                }
            }
        }
        int[] indegree= new int[26];
     
        for(int i=0; i< 26 ;i++){
            for(int element: adj.get(i)){
                indegree[element]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0 ; i< 26 ; i++){
            if(seen[i] && indegree[i]==0){
                q.offer(i);
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!q.isEmpty()){
            int num= q.poll();
            sb.append((char)(num+'a'));

            for(int neighbor: adj.get(num)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.offer(neighbor);
                }
            }
        }
        int count= countseen(seen);
        if(sb.length()!=count) return "";
        return sb.toString();
    }

    private int countseen(boolean[] seen){
        int count=0;
        for(boolean b: seen){
            if(b) count++;
        }
        return count;
    }
}