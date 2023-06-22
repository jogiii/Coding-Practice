package java8.prac;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    //supplier always return something
    // if you are using filtering and no value is filtered and you want to return some meaningful data then use supplier

    public static void main(String[] args) {
        Supplier<String> s =() -> "this is meaningful response";

       // System.out.println(s.get());


        List<String> list = Arrays.asList();
        System.out.println(list.stream().findAny().orElseGet(s));
    }
}
