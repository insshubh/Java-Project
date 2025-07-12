package com.example.producerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Producer class that implements a producer in a producer-consumer scenario.
 * This class produces items and adds them to a shared buffer.
 */
class Producer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private final Buffer buffer;
    private volatile boolean running = true;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int item = 0;
            while (running) {
                buffer.produce(item++);
                Thread.sleep(1000); // Simulate production delay
            }
        } catch (InterruptedException e) {
            logger.error("Producer interrupted", e);
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }

    // Method to stop the producer gracefully
    public void shutdown() {
        this.running = false;
    }
}
