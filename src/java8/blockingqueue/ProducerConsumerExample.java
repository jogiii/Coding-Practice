package java8.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        BlockingQueue<Integer> integerBlockingQueue = new LinkedBlockingQueue<Integer>();

        Thread producer = new Thread(new Producer(integerBlockingQueue));

        Thread consumer = new Thread(new Consumer(integerBlockingQueue));

        consumer.start();

        producer.start();
    }
}
