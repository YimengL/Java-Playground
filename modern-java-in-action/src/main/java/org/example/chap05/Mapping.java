package org.example.chap05;

import org.example.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {
        // map
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);

        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[] {i, j}))
                .filter(a -> (a[0] + a[1]) % 3 == 0)
                .collect(Collectors.toList());
        pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
    }
}
