class BoundedBlockingQueue {
    private final Deque<Integer> queue = new ArrayDeque<>();
    private final int capacity;

    private final Lock lock= new ReentrantLock();
    private final Condition notFull= lock.newCondition();
    private final Condition notEmpty=lock.newCondition();



    public BoundedBlockingQueue(int capacity) {
        this.capacity= capacity;
        
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try{
            while(queue.size()==capacity){
                notFull.await();
            }
            queue.addFirst(element);
            notEmpty.signal();

        }
        finally{
            lock.unlock();
        }
        
    }
    
    public int dequeue() throws InterruptedException {
        lock.lock();
        try{
            while(queue.size()==0){
                notEmpty.await();
            }
            int val=queue.removeLast();
            notFull.signal();
            return val;
        }
        finally{
            lock.unlock();
        }
        
    }
    
    public int size() {
        lock.lock();
        try{
            return queue.size();
        }
        finally{
            lock.unlock();
        }
    }
}