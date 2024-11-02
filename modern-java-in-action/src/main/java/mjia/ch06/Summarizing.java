package mjia.ch06;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Summarizing {

    public static void main(String[] args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
    }

    private static long howManyDishes() {
        return Dish.menu.stream().collect(counting());
    }

    private static Dish findMostCaloricDish() {
        return Dish.menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        return Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator)).get();
    }

    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return Dish.menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
    }
}
