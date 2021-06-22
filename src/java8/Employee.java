package java8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {
    public String name;
    public int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    /*public String toString()
    {
        return "Employee Name: "+name+" age: "+age;
    }*/


    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;

        Employee emp = (Employee)obj;
        return (emp.name == this.name && emp.age==this.age);
    }

    @Override
    public int hashCode() {
        final int PRIME =31;
        int result = 1;
        result = PRIME * result+this.age;
        return result;
    }



    // if we donot override hashcode method
   /* i added these emp objects to a HashSet. Set should override
   the duplicate values and should return me only one object as both
    objects are same. but after overriding equals() you can see Set functionality is disturbed.
    As per the Java documentation, developers should override both methods in order to
    achieve a fully working equality mechanism — it’s not enough to just implement the equals() method.*/


/*
    Only Override HashCode, Use the default Equals:
        Only the references to the same object will return true. In other words,
    those objects you expected to be equal
     Only Override Equals, Use the default HashCode:
        There might be duplicates in the HashMap or HashSet. We write the equals method
    and expect{"abc", "ABC"} to be equals. However, when using a HashMap, they might
    appear in different buckets, thus the contains() method will not detect them each other.
*/

    public static void main(String[] args) {
        Employee e = new Employee("joginder", 30);
        Employee e1 = new Employee("joginder", 30);


        Set<Employee> employees = new HashSet<Employee>();
        employees.add(e);
        employees.add(e1);
        System.out.println(employees);
        System.out.println(e.equals(e1));

        // if we dont override hashcode mehod then this will return two objects but as per equals these two objects
        //are equal

        //RULE
        /*If two objects are equal according to the equals(Object) method,
            then calling the hashcode() method on each of the two objects
        must produce the same integer result.
    }*/
    }

}


