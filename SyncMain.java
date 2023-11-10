public class SyncMain {
    public static void main(String[] args) {
        BoundedBuffer<Double> buffer = new BoundedBuffer<>(1000);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);

        pThread.start();
        cThread.start();

        try {
            pThread.join();
            cThread.join();
        } catch(InterruptedException e) {
            System.out.println("ERROR");
        }

        System.out.println("Exiting!");
    }
}