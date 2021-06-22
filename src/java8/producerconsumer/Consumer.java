package java8.producerconsumer;

import java.util.Vector;

public class Consumer implements Runnable{

    private final Vector sharedQueue;
    private final int SIZE;

    public Consumer(Vector sharedQueue, int SIZE) {
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }



    @Override
    public void run() {

        while(true){
            try {
                System.out.println("Comsumed :"+consume());
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private int consume() throws InterruptedException {



        while(sharedQueue.isEmpty()){
            synchronized (sharedQueue) {
                System.out.println("The queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());
                sharedQueue.wait();
            }
        }

        //otherwise consume the element

        synchronized (sharedQueue){
            sharedQueue.notifyAll();
            return (Integer)sharedQueue.remove(0);
        }
    }



}
