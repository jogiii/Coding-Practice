package java8.prac;

public class TestImpl{
    public static void main(String[] args) {
        Test t = () -> {
            System.out.println("hello");
        };
        t.display();
    }


}
