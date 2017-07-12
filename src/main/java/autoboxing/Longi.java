package autoboxing;

/**
 * Created by jfreire on 10.07.17.
 */
public class Longi {


    void method(Long i){

        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        long i = 10;

        new Longi().method(i);
    }

}
