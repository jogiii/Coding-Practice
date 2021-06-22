package java8.cloning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CloneDeep implements Cloneable {

    //cloning date object

    /*protected Object clone() throws CloneNotSupportedException {
        Employee clone = null;
        try
        {
            clone = (Employee) super.clone();

            //Copy new date object to cloned method
            clone.setDob((Date) this.getDob().clone());
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return clone;
    }*/



    //cloning array list
   /* ArrayList<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1l, "adam", new Date(1982, 02, 12)));

        System.out.println(employeeList);

    ArrayList<Employee> employeeListClone = new ArrayList<>();

    Iterator<Employee> iterator = employeeList.iterator();
        while(iterator.hasNext()){
        employeeListClone.add((Employee) iterator.next().clone());
    }

        employeeListClone.get(0).setId(2l);
        employeeListClone.get(0).setName("brian");
        employeeListClone.get(0).getDob().setDate(13);;

        System.out.println(employeeList);
        System.out.println(employeeListClone);*/

    public CloneDeep(String name,Map<Integer,Integer> map){
        this.name=name;
        this.map=map;
    }

    private String name;
    private Map<Integer,Integer> map;

    /*
     * override clone method for doing deep copy.
     */
    @Override
    public CloneDeep clone(){
        System.out.println("Doing deep copy");

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        Iterator<Integer> it=this.map.keySet().iterator();
        while(it.hasNext()){
            Integer key=it.next();
            map.put(key,this.map.get(key) );
        }

        CloneDeep cloneDetailedDeep=new CloneDeep(new String(name), map);

        return cloneDetailedDeep;
    }

    public static void main(String[] args) throws CloneNotSupportedException  {



        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(1, 11);

        CloneDeep obj1=new CloneDeep("sam",map);

        CloneDeep obj2=(CloneDeep)obj1.clone();

        System.out.println(obj1==obj2);           //false
        System.out.println(obj1.name==obj2.name); //false
        System.out.println(obj1.map==obj2.map);   //false



    }

}