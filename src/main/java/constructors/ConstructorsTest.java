package constructors;

class A {

    A() {
        System.out.print("Super ");
    }

}

/**
 * First a new instance of ConstructorsTest, runs super() (A), then own no args constructor called from args constructor,
 * then method then cheeky method returning void and with same name as constructor
 */
public class ConstructorsTest extends A {

    public static void main(String[] args) {
        new ConstructorsTest(1L).ConstructorsTest();//.ConstructorsTest();

    }

    public ConstructorsTest(int x) {
        this();
        System.out.print(" " + (x * 2));
    }

    public ConstructorsTest(long x) {
        this((int) x);
        System.out.print(" " + x);
    }

    public ConstructorsTest() {
        super();
        System.out.print("No arg Sub");
    }

    void ConstructorsTest() {
        System.out.print(" method ");
    }

}