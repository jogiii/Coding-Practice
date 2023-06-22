package java8.prac;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

    // Function takes an argument and return an argument
    // we can use it in map()

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10);
        //n -> n * 2 this is a function
        numbers.stream()
                .map(n -> n * 2)
                .forEach(System.out::println);

    }
}
