
/**
 * Created by jfreire on 06.07.17.
 */
public class ValidatorLambda {

    public static void main(String[] args) {

        String l = "Aasadfasdfasdsadf";

        Validator val = new Validator() {
            @Override
            public boolean test(String s) {
                return s.matches("[A]{1}[a-zA-Z]+");
            }
        };

        Validator lambdaVal = z -> z.matches("[A]{1}[a-zA-Z]+");

        Validator lambdaValAlt = z -> {return z.matches("[A]{1}[a-zA-Z]+");};

        //Variable can't be named undescore, putas! _
        //Validator lambdaValInv = z -> {_.matches("[A]{1}[a-zA-Z]+")};


        System.out.println("val.test(l) = " + val.test(l));

        System.out.println("lambdaVal.test(l) = " + lambdaVal.test(l));

        System.out.println("lambdaValAlt = " + lambdaValAlt.test(l));
    }

    interface Validator {
        boolean test(String t);
    }
}
