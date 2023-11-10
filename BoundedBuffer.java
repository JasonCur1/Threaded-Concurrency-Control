public class BoundedBuffer<E> {
    double[] array;
    int size;
    int capacity;
    int head;
    int tail;

    public BoundedBuffer(int capacity) {
        array = new double[capacity];
        this.capacity = capacity;
        this.size = 0;
        head = 0;
        tail = -1;
    }

    public void add(double element) {
        synchronized(array) {
            //buffer is full | must wait
            if (size == capacity) {
                try {
                    array.wait();
                } catch (InterruptedException e) {
                    System.out.println("INTERRUPTED");
                }
            }
            

            size++;
    
            // buffer isn't full 
            int index = (tail + 1) % capacity;
            array[index] = element;
            tail++;

            array.notify();
        }
    }

    public double retrieve() {
        synchronized(array) {
            //buffer is empty | must wait
            if (size == 0) {
                try {
                    array.wait();
                } catch (InterruptedException e) {
                    System.out.println("INTERRUPTED");
                }
            }
    
            int index = head % capacity;
            double element = array[index];
            head++;
            size--;

            array.notify();
    
            return element;
        }
        
    }

    // empty status
    public boolean isEmpty() {
        return size == 0;
    }

    // full status
    public boolean isFull() {
        return size == capacity;
    }
}