package com.example.producerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Producer class that implements a producer in a producer-consumer scenario.
 * This class produces items and adds them to a shared buffer.
 */
class Consumer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private final Buffer buffer;
    private volatile boolean running = true;
    private final int  delay = 3000; // Default delay for consumption

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (running) {
                int item = buffer.consume();
                System.out.println("Consumed time: " + item);
                Thread.sleep(delay); // Simulate consumption delay
            }
        } catch (InterruptedException e) {
            logger.error("Consumer interrupted", e);
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }

    // Method to stop the consumer gracefully
    public void shutdown() {
        this.running = false;
    }
}