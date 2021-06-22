package other;

public class Demo extends A {

   int a =150;


   public Demo(Test td) {
      super(td);
   }

   public static void main(String[] args) {

      Test td = new Test();
      A a = new Demo(td);
      System.out.println(a.a);
   }
}
