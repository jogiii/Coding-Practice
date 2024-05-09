package immutable;

public class RunnableClass {

    public static void main(String[] args) throws InterruptedException {
        final String str = "test";
        str.chars().forEach(System.out::println);
    }

    @AutoValidation
    public void validateData() {
        System.out.println("this is run at runtime");
    }

   static  class MyRunnable implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<2;i++){
                System.out.println(Thread.currentThread().getName()+ " "+ i);
            }
        }
    }
}
