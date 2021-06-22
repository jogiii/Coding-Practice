package java8.producerconsumer;

import java.util.Vector;

public class ProducerConsumerSolution {

    public static void main(String[] args) {
        Vector sharedQueue = new Vector();

        int size=4;

        Thread producer = new Thread(new Producer(sharedQueue,size),"Producer");
        Thread consumer = new Thread(new Consumer(sharedQueue,size),"Consumer");

        producer.start();
        consumer.start();
    }
}
