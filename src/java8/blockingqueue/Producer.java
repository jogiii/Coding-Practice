package java8.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements  Runnable{
    private final BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 10; i <= 100; i += 10) {
            try {
                System.out.println("Data produced : " + i);
                blockingQueue.put(i);
            } catch (InterruptedException ex) {
                System.out.println("Producer thread interrupted.");
            }
        }
    }
}
