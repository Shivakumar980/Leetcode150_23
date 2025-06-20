class H2O {

    private final Lock lock= new ReentrantLock();
    private final Condition hydrogenCondition=lock.newCondition();
    private final Condition oxygenCondition=lock.newCondition();
    private int hydrogenCount=0;
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try{
            while(hydrogenCount==2){
                hydrogenCondition.await();
            }
        
        releaseHydrogen.run();
        hydrogenCount++;
        if(hydrogenCount==2){
            oxygenCondition.signal();
        }
    }
    finally{
        lock.unlock();
    }

           
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        lock.lock();
        try{
            while(hydrogenCount<2){
                oxygenCondition.await();
            }
		    releaseOxygen.run();
            hydrogenCount=0;
            hydrogenCondition.signalAll();

        }
        finally{
            lock.unlock();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
    }
}