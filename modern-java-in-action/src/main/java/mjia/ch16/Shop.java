package mjia.ch16;

import static mjia.ch16.Util.delay;

import java.util.Random;

public class Shop {

    private final Random random;

    public Shop(Random random) {
        this.random = random;
    }

    public double getPrice(String product) {
        return 0.0;
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
