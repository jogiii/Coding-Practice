package java8;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class MaximumUsingStreamMain {

    public static void main(String[] args) {
       List<Employee> employeeList = createEmployeeList();

     long countemp = employeeList.stream().filter(e->e.getAge()==25).count();

     Optional<Employee> empName = employeeList.stream().filter(e->e.getName()=="Marry").findAny();

        int num1 = 2;
        int num2 = 4;

        BiFunction<Integer,Integer,Integer> func = (i1,i2) -> (i1*i2);

        int a =func.apply(num1,num2);
        System.out.println(a);

       List<Integer> test = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
       List<Integer> filList = test.stream().skip(4).limit(8).map(x->x*x).collect(Collectors.toList());
        System.out.println(filList);

        BiFunction<Integer,Integer,Integer> bi = (x,y) -> (x*y);
        Integer a1 = bi.apply(10,20);

        Comparator<Employee> comparator = Comparator.comparing(Employee::getAge).reversed().thenComparing(Employee::getName);
        Collections.sort(employeeList,comparator);
        System.out.println(employeeList);

        System.out.println(a);

        List<String> employeeFilteredList = employeeList.stream()
                .filter(e->e.getAge()>20)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(employeeFilteredList);
        long count = employeeList.stream()
                .filter(e->e.getAge()>20)
                .count();
        System.out.println(count);

        Optional<Employee> e1 = employeeList.stream()
                .filter(e->e.getName().equalsIgnoreCase("Marry"))
                .findAny();

        List<String> employeeNames = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        String empmm = String.join(",",employeeNames);

        Map<String, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        map.forEach((name,employeeListTemp)->System.out.println("Name: "+name+" ==>"+employeeListTemp));



        List<String> employeeFiltered =  employeeList.stream().filter(e->e.getAge()>20).map(Employee::getName).collect(Collectors.toList());
        System.out.println(employeeFiltered);
     }

    public static List<Employee> createEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();

        Employee e1 = new Employee("jogi",28);
        Employee e2 = new Employee("jogi1",18);
        Employee e3 = new Employee("jogi2",38);
        Employee e4 = new Employee("jogi3",8);
        Employee e5 = new Employee("jogi4",58);


        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        return  employeeList;

    }
}
