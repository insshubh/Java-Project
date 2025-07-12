package com.example.producerconsumer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Buffer class that implements a thread-safe bounded buffer using BlockingQueue.
 * This class provides methods to produce and consume items in a producer-consumer scenario.
 */
class Buffer {
    private static final Logger logger = LoggerFactory.getLogger(Buffer.class);
    private final BlockingQueue<Integer> queue; // Thread-safe queue
    private static final int CAPACITY = 5; // Configurable buffer size

    public Buffer() {
        this.queue = new ArrayBlockingQueue<>(CAPACITY);
    }

    // Produce an item and add to queue
    public void produce(int item) throws InterruptedException {
        logger.info("Producing item: {}", item);
        queue.put(item); // Blocks if queue is full
        logger.info("Produced item: {}, Queue size: {}", item, queue.size());
    }

    // Consume an item from queue
    public int consume() throws InterruptedException {
        int item = queue.take(); // Blocks if queue is empty
        logger.info("Consumed item: {}, Queue size: {}", item, queue.size());
        return item;
    }
}
