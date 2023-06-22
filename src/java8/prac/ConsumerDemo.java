package java8.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
//consumer ony accepts object and perform operation as per logic with no return type
    public static void main(String[] args) {
     //  Consumer<Integer> c = t ->System.out.println("printig value :"+t);


      // c.accept(10);

        List<Integer> i = Arrays.asList(1,2,3,4);
        //i.stream().forEach(c);

        i.stream().forEach(t ->System.out.println("printig value :"+t));
    }
}
