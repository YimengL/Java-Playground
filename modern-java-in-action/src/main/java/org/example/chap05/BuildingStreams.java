package org.example.chap05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args) {
        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/chap05/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            System.out.println("Failed to open the file");
        }
        System.out.println(uniqueWords);
    }
}
