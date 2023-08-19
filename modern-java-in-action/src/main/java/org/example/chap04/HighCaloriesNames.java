package org.example.chap04;

import java.util.List;
import java.util.stream.Collectors;

public class HighCaloriesNames {

    public static void main(String[] args) {
        List<String> names = Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
