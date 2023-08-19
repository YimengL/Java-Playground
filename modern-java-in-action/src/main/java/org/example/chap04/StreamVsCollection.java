package org.example.chap04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollection {
    public static void main(String[] args) {
        List<String> name = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = name.stream();
        s.forEach(System.out::println);

        // uncommenting this line will result in an IllegalStackException
        // because streams can be consumed only once
        // s.forEach(System.out::println);
    }
}
