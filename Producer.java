import java.util.Random;

public class Producer implements Runnable {
    private final int NUM_ITEMS_TO_PRODUCE = 1000000;
    private BoundedBuffer<Double> buffer;
    private double bufferValueCounter;

    public Producer(BoundedBuffer<Double> buffer) {
        this.buffer = buffer;
        this.bufferValueCounter = 0;
    }

    public void run() {
        // produce 1,000,000 items
        int i = 0;
        do {
            // make next buffer element
            Random random = new Random();
            Double bufferElement = random.nextDouble() * 100.0;

            // attempt to add to buffer
            buffer.add(bufferElement);

            // clean up and conditional print
            i++;
            bufferValueCounter += bufferElement;

            if (i % 100000 == 0) {
                System.out.printf("Producer: Generated %,d items, Cumulative value of generated items=%.3f\n", i, bufferValueCounter);
            }
        } while (i < NUM_ITEMS_TO_PRODUCE);
        System.out.printf("Producer: Finished generating %,d items\n", i);
    }
}