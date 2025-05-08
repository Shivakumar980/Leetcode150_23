class Solution {
    public String reverseWords(String s) {
        
        int n= s.length();
        ArrayList<String> al= new ArrayList<String>();
        int front= n-1;
        int rear= n-1;
        while(front>=0){
            char f= s.charAt(front);
            char r= s.charAt(rear);
            if(f==' ' && r== ' '){
                front--;
                rear--;
            }
            else if(f==' ' && r!=' '){
                al.add(s.substring(front+1, rear+1));
                rear=front;  
            }
            else{
                front--;
            }
        }
        if(rear>=0 &&  s.charAt(rear)!=' '){
            al.add(s.substring(0,rear+1));
        }

        return String.join(" ",al);
    }
}