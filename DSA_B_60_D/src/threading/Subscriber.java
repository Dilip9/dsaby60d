public class Subscriber implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Subscriber(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = queue.take();
                System.out.println("Consumed: " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}