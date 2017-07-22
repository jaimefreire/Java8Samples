package snippets.interfaces;

public class InterfaceMethods {
    public static void main(String[] args) {
        In0 in = new Aa();
//Can't be called as interface methods don't get inherited
//        in.method();
        In0.method();
        //
        in.methods();
    }
}

interface In0 {
    public final static int x = 10;

    static void method() {
        System.out.println(x);
    }

    default void methods() {
        System.out.println(x);
    }
}

class Aa implements In0 {
    @Override
    public void methods() {
        System.out.println(x + 1);
    }
}