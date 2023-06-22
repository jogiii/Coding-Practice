package java8.prac;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    //predicates are used for conditional check
    //predicate is also used in filter method in streaming

    public static void main(String[] args) {
      // Predicate<Integer> p = t -> t % 2 ==0;
       // System.out.println(p.test(6));

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        //list.stream().filter(p).forEach(t -> System.out.println("even no :"+t));

        list.stream().filter( t -> t % 2 ==0).forEach(t -> System.out.println("even no :"+t));
    }
}
