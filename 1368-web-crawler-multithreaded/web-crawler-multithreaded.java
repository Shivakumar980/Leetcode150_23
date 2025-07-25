/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName= getHostName(startUrl);

        List<String> res= new ArrayList<>();
        Set<String> visited= new HashSet<>();
        BlockingQueue<String> queue= new LinkedBlockingQueue<>();
        Deque<Future> tasks= new ArrayDeque<>();

        queue.offer(startUrl);
        ExecutorService executor= Executors.newFixedThreadPool(4, r->{
            Thread t= new Thread(r);
            t.setDaemon(true);
            return t;
        }) ;

        while(true){
            String url= queue.poll();
            if(url!=null){
                if(hostName.equals(getHostName(url)) && !visited.contains(url)){
                    res.add(url);
                    visited.add(url);
                    tasks.add(executor.submit(()-> {
                        List<String> newUrls=  htmlParser.getUrls(url);;
                        for(String newUrl: newUrls){
                            queue.offer(newUrl);
                        }
                    }));
                }
            }
            else{
                if(!tasks.isEmpty()){
                    Future nextTask=tasks.poll();
                    try{
                        nextTask.get();
                    }
                    catch(InterruptedException | ExecutionException e){

                    }
                }
                else{
                    break;
                }
            }
        }
        return res;
    }

    public String getHostName(String url){
        url=url.substring(7);
        String[] parts=url.split("/");
        return parts[0];
    }
}