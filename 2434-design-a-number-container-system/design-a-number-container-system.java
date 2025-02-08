class NumberContainers {

    private Map<Integer, TreeSet<Integer>> numbertoIndices;
    private Map<Integer,Integer> indextoNumbers;
    public NumberContainers() {
        numbertoIndices= new HashMap<>();
        indextoNumbers= new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indextoNumbers.containsKey(index)){
            int num= indextoNumbers.get(index);
            numbertoIndices.get(num).remove(index);
            if(numbertoIndices.get(num).isEmpty()){
                numbertoIndices.remove(num);
            }
            
        }
       numbertoIndices.putIfAbsent(number, new TreeSet<>());
            numbertoIndices.get(number).add(index);
            indextoNumbers.put(index, number);

    }
    
    public int find(int number) {
       if(numbertoIndices.containsKey(number)){
            return numbertoIndices.get(number).first();
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