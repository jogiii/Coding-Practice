package java8.bifunction;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class multiplylambda {

    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 4;

        BiFunction<Integer,Integer,Integer> func = (i1,i2) -> (i1*i2);

        int a =func.apply(num1,num2);
        System.out.println(a);

        BiConsumer<String,String> biconsumer = (x,y) ->{
            System.out.println("x : "+x+" y :"+y);
        };
        biconsumer.accept("sun","moon");
    }
}
