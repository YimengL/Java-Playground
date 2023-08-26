package org.example.chap05;

import org.example.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class NumericStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        Arrays.stream(numbers.toArray())
                .forEach(System.out::println);
        int calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories: " + calories);

        // max and OptionalInt
        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        // Provides an explicit default maximum if there's no value
        int max = maxCalories.orElse(1);
        System.out.println(max);

        // numeric ranges

    }
}
