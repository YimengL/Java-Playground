package mjia.ch06;

import static java.util.stream.Collectors.reducing;

public class Reducing {
    public static void main(String[] args) {
        System.out.println("Total calories in menu: " + calculateTotalCalories());

    }

    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
    }
}
