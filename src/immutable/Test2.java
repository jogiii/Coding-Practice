package immutable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) throws Exception{
       List ints = Arrays.asList(1,2);
       List nums = ints;
       nums.add(3.14);
    }
}
