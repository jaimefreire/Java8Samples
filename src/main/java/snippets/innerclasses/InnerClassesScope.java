package snippets.innerclasses;

/**
 * Created by jfreire on 10.07.17.
 */
public class InnerClassesScope {

    //Valid declarations
    int x = new Integer(1);
    Integer y = 3;

    class A {
        String _;
    }

    void method() {
        class B {
            String $;
        }


    }
}
