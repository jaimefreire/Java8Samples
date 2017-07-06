package defaultmethods;

/**
 * Created by jfreire on 06.07.17.
 */
public class DefaultMethods {

    interface I
    {

        //default method can't override Object methods
        default String toStrong() {
            return "NONONO";
        }
    }

    public static void main(String[] args) {
        I i = new I(){};

        System.out.println("i.toStrong() = " + i.toStrong());
    }
    
    
}
