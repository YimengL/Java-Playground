package mjia.ch06;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Summarizing {

    public static void main(String[] args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
    }

    private static long howManyDishes() {
        return Dish.menu.stream().collect(counting());
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        return Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator)).get();
    }
}
