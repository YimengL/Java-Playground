package org.example.chap03;

public class Lambdas {
    public static void main(String[] args) {
        // Simple example
        Runnable r = () -> System.out.println("Hello");
        r.run();
    }
}
