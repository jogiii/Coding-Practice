package immutable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass
{

    /**
     * Integer class is immutable as it does not provide any setter to change its content
     * */
    private final Integer immutableField1;

    /**
     * String class is immutable as it also does not provide setter to change its content
     * */
    private final String immutableField2;

    /**
     * Date class is mutable as it provide setters to change various date/time parts
     * */
    private final Date mutableField;

    private final ArrayList listOfStates;

    private final Map<String, String> metadata;
    private final Age age;

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());

        return cloneAge;
    }

    //Default private constructor will ensure no unplanned construction of class
    private ImmutableClass(Integer fld1, String fld2, Date date, ArrayList listOfStates,
                           Map<String, String> metadata, Age age)
    {
        this.immutableField1 = fld1;
        this.immutableField2 = fld2;
        this.mutableField = new Date(date.getTime());



        ArrayList tempList = new ArrayList();

        for (int i = 0; i < listOfStates.size(); i++) {
            tempList.add(listOfStates.get(i));
        }
        this.listOfStates = tempList;

        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metadata = tempMap;

        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;

    }

    //Factory method to store object creation logic in single place
    public static ImmutableClass createNewInstance(Integer fld1, String fld2,
                                                   Date date,ArrayList listOfStates,
                                                   Map<String, String> metadata,Age age)
    {
        return new ImmutableClass(fld1, fld2, date, listOfStates, metadata, age);
    }

    //Provide no setter methods
    public ArrayList getListOfStates() {
        return listOfStates;
    }
    /**
     * Integer class is immutable so we can return the instance variable as it is
     * */
    public Integer getImmutableField1() {
        return immutableField1;
    }

    /**
     * String class is also immutable so we can return the instance variable as it is
     * */
    public String getImmutableField2() {
        return immutableField2;
    }

    /**
     * Date class is mutable so we need a little care here.
     * We should not return the reference of original instance variable.
     * Instead a new Date object, with content copied to it, should be returned.
     * */
    public Date getMutableField() {
        return new Date(mutableField.getTime());
    }

    @Override
    public String toString() {
        return immutableField1 +" - "+ immutableField2 +" - "+ mutableField;
    }
}
