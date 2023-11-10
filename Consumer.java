public class Consumer implements Runnable {
    private final int NUM_ITEMS_TO_PRODUCE = 1000000;
    private BoundedBuffer<Double> buffer;
    private double bufferValueCounter;

    public Consumer(BoundedBuffer<Double> buffer) {
        this.buffer = buffer;
        this.bufferValueCounter = 0;
    }

    public void run() {
        // consume 1,000,000 items
        int i = 0;
        do {
            // attempt to retrieve and store value
            bufferValueCounter += buffer.retrieve();
            
            // clean up and conditional print
            i++;
            if (i % 100000 == 0) {
                System.out.printf("Consumer: Consumed %,d items, Cumulative value of consumed items=%.3f\n", i, bufferValueCounter);
            }

        } while (i < NUM_ITEMS_TO_PRODUCE);
        System.out.printf("Consumer: Finished consuming %,d items\n", i);
    }
}