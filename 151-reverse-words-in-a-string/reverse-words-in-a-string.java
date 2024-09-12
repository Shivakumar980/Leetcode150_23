class Solution {
    public String reverseWords(String s) {
        ArrayList<String> sl=new ArrayList<>();
        int front=s.length()-1; 
        int rear=s.length()-1;
        while(front >=0 && rear>=0){
            char f=s.charAt(front);
            char r=s.charAt(rear);
            System.out.println(f+" "+r);
            if(f==' '&& r== ' '){
                front--;
                rear--;
            }
            else if(f==' ' && r !=' '){
                sl.add(s.substring(front+1,rear+1));
                rear=front;
                //System.out.println(s.substring(front+1,rear+1));
            }
            else{
                front--;
            }
            
        }
       if (rear >= 0 && s.charAt(rear) != ' ') {
            sl.add(s.substring(0, rear + 1));
        }
        return String.join(" ", sl);
    }
}