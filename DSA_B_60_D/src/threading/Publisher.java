public class Publisher implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Publisher(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Publishing: " + i);
                queue.put(i);
                Thread.sleep(100); // Simulate time taken to produce an item
            }
            queue.put(-1); // Indicate end of publishing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}