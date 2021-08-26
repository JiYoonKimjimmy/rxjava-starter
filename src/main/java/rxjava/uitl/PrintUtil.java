package rxjava.uitl;

public class PrintUtil {
    public static void printData(String message) {
        System.out.println("" + Thread.currentThread().getName() + " | " + message);
    }

    public static void printData(String message, Object obj) {
        System.out.println("" + Thread.currentThread().getName() + " | " + message + " | " + obj.toString());
    }
}