package java8.deadlock;

public class NewDeadLockTest {

    public static void main(String[] args) {

        NewDeadLockTest test = new NewDeadLockTest();


        final A a = test.new A();
        final B b = test.new B();


        Runnable block1 = new Runnable() {
            @Override
            public void run() {

                synchronized (a){
                    try {
                        System.out.println("acquried a's lock, waiting for b");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println("inside block 1");
                    }
                }



            }
        };


        Runnable block2 = new Runnable() {
            @Override
            public void run() {

                synchronized (b){
                    System.out.println("acquried b's lock waiting for a");
                    synchronized (a){
                        System.out.println("inside block 2");
                    }
                }

            }
        };

        new Thread(block1).start();
        new Thread(block2).start();

    }


//resource A
    private class A{
        int i=20;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
//resource B
    private class B{
        int i=20;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
