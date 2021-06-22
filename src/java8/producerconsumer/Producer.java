package java8.producerconsumer;

import java.util.Vector;

public class Producer implements Runnable{

    private final Vector sharedQueue;
    private final int SIZE;

    public Producer(Vector sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for(int i=0;i<7;i++){
            System.out.println("Produced: "+i);

            try {
                produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    private void produce(int i) throws InterruptedException {

        // if size is full then put to wait
        while(sharedQueue.size()== SIZE){
            synchronized (sharedQueue) {
                System.out.println("The queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //else adding the element to queue and notifying other consumers
        synchronized (sharedQueue){
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}
