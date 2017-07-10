package hierarchies;

/**
 * Created by jfreire on 10.07.17.
 */
public class InterfacesAndAbstractClasses {


    public static void main(String[] args) {
        D d = new F();
        d.a(1);
        
    }
}

interface A {
    int lala=2;

    default void a(int uno){
        System.out.println("BB: " + lala);
    }
}

interface B {
    int lala=1;

    void b(int uno);
}

abstract class C implements A, B {
    public void a(int l) {
        System.out.println("l: " + l);
    }
}

interface D extends A, B {
int lala=4;
//    void a(int l);
//    void b(int l);
}

class F implements D{

    @Override
    public void a(int l) {
        System.out.println("AAA: " + lala);
    }

    @Override
    public void b(int l) {
        System.out.println("BBB");

    }
}


