package snippets.overrides;

/**
 * Created by jfreire on 06.07.17.
 */
public class Overrides {

    Overrides(){
        new A().print();

        new B().print();

        new B().print("C");
    }


    class A{
        protected void print(){
            System.out.println("A");
        }
    }
    class B extends A{
        protected void print(){
            System.out.println("B");
        }

        void print(String A)
        {
            System.out.println(A);
        }

    }

    public static void main(String[] args) {

       new Overrides();

    }


}
