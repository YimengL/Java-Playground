package org.example.chap05;

import org.example.chap04.Dish;

import java.util.Arrays;
import java.util.List;

public class NumericStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        Arrays.stream(numbers.toArray())
                .forEach(System.out::println);
        int calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories: " + calories);
    }
}
