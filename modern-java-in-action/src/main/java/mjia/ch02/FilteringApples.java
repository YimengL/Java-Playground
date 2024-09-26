package mjia.ch02;

import java.util.ArrayList;
import java.util.List;

import static mjia.ch02.FilteringApples.Color.RED;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = List.of(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, RED)
        );

        // Apple{color='GREEN', weight=80}, Apple{color='GREEN', weight=155}
        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        System.out.println(greenApples);

        // Apple{color='RED', weight=120}
        List<Apple> redApples = filterApplesByColor(inventory, RED);
        System.out.println(redApples);

        // Apple{color='GREEN', weight=80}, Apple{color='GREEN', weight=155}
        List<Apple> greenApples2 = filter(inventory, new AppleGreenColorPredicate());
        System.out.println(greenApples2);

        // Apple{color='GREEN', weight=155}]
        List<Apple> heavyApples = filter(inventory, new AppleHeavyWeightPredicate());
        System.out.println(heavyApples);

        // []
        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        // Apple{color='RED', weight=120}]
        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });
        System.out.println(redApples2);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    enum Color {
        RED,
        GREEN
    }

    public static class Apple {
        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }
    }

    interface ApplePredicate {
        boolean test(Apple apple);
    }

    static class AppleHeavyWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    static class AppleGreenColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return Color.GREEN.equals(apple.getColor());
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return RED.equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

}
