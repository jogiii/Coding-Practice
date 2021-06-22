package other;

import java8.Employee;

public class EqualsAndHashCode {

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Employee emp = (Employee) obj;
        return true;
    }
}
