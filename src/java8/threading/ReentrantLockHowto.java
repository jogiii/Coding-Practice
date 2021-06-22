package java8.threading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHowto {

    private final ReentrantLock lock = new ReentrantLock();
    private int count =0;

    public int getCount(){

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "gets count" + count);
            return count++;
        }
        finally {
            lock.unlock();
        }


    }

    public synchronized int getCountTwo(){
        return count++;
    }

    public static void main(String args[]) {
        final ReentrantLockHowto counter = new ReentrantLockHowto();
        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (counter.getCount() < 6) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();                    }
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {
                while (counter.getCount() < 6) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        t2.start();

    }



}
