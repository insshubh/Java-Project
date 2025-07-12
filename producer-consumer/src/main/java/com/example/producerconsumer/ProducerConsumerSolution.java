package com.example.producerconsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ProducerConsumerSolution {
    private static final Logger logger = LoggerFactory.getLogger(ProducerConsumerSolution.class);

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        // Start threads
        Thread producerThread = new Thread(producer, "Producer-Thread");
        Thread consumerThread = new Thread(consumer, "Consumer-Thread");

        logger.info("Starting Producer-Consumer system...");
        producerThread.start();
        consumerThread.start();

        // Run for a fixed time (e.g., 5 seconds) then shutdown
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("Main thread interrupted", e);
            Thread.currentThread().interrupt();
        }

        producer.shutdown();
        consumer.shutdown();
        logger.info("Shutting down Producer-Consumer system...");
    }
}