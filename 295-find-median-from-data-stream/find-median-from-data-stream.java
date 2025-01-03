class MedianFinder {

    PriorityQueue<Integer> smallheap;
    PriorityQueue<Integer> largeheap;
    public MedianFinder() {
      
        smallheap= new PriorityQueue<>((a,b)->b-a);
        largeheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallheap.add(num);

        if(largeheap.size()!=0 && smallheap.size()!=0 && smallheap.peek()>largeheap.peek()){
            largeheap.add(smallheap.poll());
        }
        if(largeheap.size()-smallheap.size()>1){
            smallheap.add(largeheap.poll());
        }
        if(smallheap.size()-largeheap.size()>1){
            largeheap.add(smallheap.poll());
        }  
    }
    
    public double findMedian() {
        if(largeheap.size()==smallheap.size()){
            return (double)(largeheap.peek()+smallheap.peek())/2;
        }
        if(largeheap.size()>smallheap.size()){
            return (double)largeheap.peek();
        }
        else{
            return  (double)smallheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */