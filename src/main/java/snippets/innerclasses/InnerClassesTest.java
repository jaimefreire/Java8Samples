package snippets.innerclasses;

/**
 * Created by jfreire on 05.07.17.
 */
public class InnerClassesTest {


    int xClass = 0;
    static int xClassStatic = 0;


    public static void method(int u, final int y) {
        int x = 0;

        class P {
            public void get() {
                int zz;
                // Can't access u as it's not final (like y) or effectively final (like x).
                //x=3;

                zz = +1 + y + x;

            }

        }
        u = x + 1;
    }

    static class P {

        public void method() {
            //xClass Can't access, not static
            xClassStatic++; // Can access as it's static.
        }

    }

    public static void method2() {


    }

   static class Main

    {
        public static void main (String[] args){

        System.out.println("MAIN");
    }
    }

}
