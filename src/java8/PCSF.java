package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PCSF {



    public void whenNamesPresentConsumeAll(){
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(printConsumer);
    }
//andThen and accept
    public void whenNamesPresentUseBothConsumer(){
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }


    public void supplier(){
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
    }

    public void testPredicate(){
        List<String> names = Arrays.asList("jhon","Smith","Sjogi","peter","harry");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");


        names.stream().filter(nameStartsWithS).forEach(System.out::println);
    }

    public void testPredicateAndComposition(){
        List<String> names = Arrays.asList("Somes","Smith","Shiney","Jogi","Hello");

        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        Predicate<String> lengthPredicate = str -> str.length() >=5;

        names.stream().filter(nameStartsWithS.and(lengthPredicate)).forEach(System.out::println);
    }


    public void testFunctions(){
        List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");

        Function<String,Integer> nameMappingFunction = String::length;

        List<Integer> nameLength =  names.stream().map(nameMappingFunction).collect(Collectors.toList());

        System.out.println(nameLength);
    }
    public static void main(String[] args) {
        PCSF pcsf = new PCSF();
        pcsf.whenNamesPresentUseBothConsumer();
    }
}
