package java8.deadlock;

public class TestDeadLock {

    public static void main(String[] args) {
        final String resource1= "joginder";
        final String resource2="Kumar";


        Runnable r1 = new Runnable() {
            @Override
            public void run() {

                synchronized (resource1){
                    System.out.println("Thread 1 : locked resource 1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    synchronized (resource2){
                        System.out.println("Thread 1 :locked resource 2");
                    }
                }


            }
        };


        Runnable r2 = new Runnable() {
            @Override
            public void run() {


                synchronized (resource2){
                    System.out.println("Thread 2 locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (resource1){
                        System.out.println("Thread 2 locked resource 1");
                    }
                }



            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
