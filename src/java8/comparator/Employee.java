package java8.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public Employee(Integer id, String firstName, String lastName, Integer age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    //Other getter and setter methods

    @Override
    public String toString() {
        return "\n["+this.id+","+this.firstName+","+this.lastName+","+this.age+"]";
    }

    private static List<Employee> getEmployees(){
        List<Employee> employees  = new ArrayList<>();
        employees.add(new Employee(6,"Yash", "Chopra", 25));
        employees.add(new Employee(2,"Aman", "Sharma", 28));
        employees.add(new Employee(3,"Aakash", "Yaadav", 52));
        employees.add(new Employee(5,"David", "Kameron", 19));
        employees.add(new Employee(4,"James", "Hedge", 72));
        employees.add(new Employee(8,"Balaji", "Subbu", 88));
        employees.add(new Employee(7,"Karan", "Johar", 59));
        employees.add(new Employee(1,"Lokesh", "Gupta", 32));
        employees.add(new Employee(9,"Vishu", "Bissi", 33));
        employees.add(new Employee(10,"Lokesh", "Ramachandran", 60));
        return employees;
    }


    public static void main(String[] args) {
        List<Employee> employees = getEmployees();

        BlockingQueue<Integer> lbq = new LinkedBlockingDeque<Integer>();
        BlockingQueue<Integer> lbq1 = new LinkedBlockingQueue<Integer>();

        lbq.add(1);
        //lbq1.put();




        //employees.sort(Comparator.comparing(e -> e.getFirstName()));
       // employees.sort(Comparator.comparing(Employee::getFirstName));
        //System.out.println(employees);

        //employees.sort(Comparator.comparing(e ->e.getLastName()));

        //reverse order

        //Comparator<Employee> comparator = Comparator.comparing(Employee::getFirstName);

        //employees.sort(comparator.reversed());
        //System.out.println(employees);


        //using multiple fields
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        employees.sort(groupByComparator);

        System.out.println(employees);



    }
}
