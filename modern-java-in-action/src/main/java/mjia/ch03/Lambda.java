package mjia.ch03;

public class Lambda {
    public static void main(String[] args) {
        // Simple Example
        Runnable r = () -> System.out.println("Hello!");
        r.run();
    }
}
