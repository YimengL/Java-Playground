package mjia.ch02;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = List.of(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        // Apple{color='GREEN', weight=80}, Apple{color='GREEN', weight=155}
        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);
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
}
