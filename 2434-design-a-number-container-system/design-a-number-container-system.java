class NumberContainers {

    private Map<Integer, PriorityQueue<Integer>> numbertoIndices;
    private Map<Integer,Integer> indextoNumbers;
    public NumberContainers() {
        numbertoIndices= new HashMap<>();
        indextoNumbers= new HashMap<>();
    }
    
    public void change(int index, int number) {
        indextoNumbers.put(index, number);
        numbertoIndices.computeIfAbsent(number, k-> new PriorityQueue<>())
                        .add(index);

    }
    
    public int find(int number) {
       if(!numbertoIndices.containsKey(number)){
            return -1;
       }
       PriorityQueue<Integer> minHeap= numbertoIndices.get(number);
       while(!minHeap.isEmpty()){
        int index= minHeap.peek();

        if(indextoNumbers.get(index)==number){
            return index;
        }

        minHeap.poll();
       }
       return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */