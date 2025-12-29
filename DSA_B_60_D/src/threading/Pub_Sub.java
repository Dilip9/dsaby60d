public class Pub_Sub {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Publisher publisher = new Publisher(queue);
        Subscriber subscriber1 = new Subscriber(queue);
        try{
            public synchronized (){

                Thread pThread = new Thread(publisher);
                Thread sThread = new Thread(subscriber1);
                pThread.start();
                Thread.sleep(1000); // Ensure publisher starts first
                sThread.start();

            }

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}