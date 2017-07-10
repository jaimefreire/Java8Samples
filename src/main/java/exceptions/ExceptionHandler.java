package exceptions;

public class ExceptionHandler {
    public static void main(String[] a) {
        try {
            method();
        } catch (Exception e) {
        }
    }

    static void method() {
        try {
//            throw new Exception(); Doesn't compile as it's a checked exception not thrown
// by the method
            throw new NullPointerException(); // Prints the finally
        } catch (ArithmeticException e) {
            System.out.println("a");
        } finally {
            System.out.println("c");
        }
        System.out.println("d"); //Only if no exceptions are thrown
    }
}