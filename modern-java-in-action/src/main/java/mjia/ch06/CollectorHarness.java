package mjia.ch06;

import java.util.function.Consumer;

public class CollectorHarness {
    public static void main(String[] args) {
        System.out.println("Partitioning done in: " + execute(PartitionPrimeNumbers::partitionPrimes) + " msecs");
        System.out.println("Partitioning done in: " + execute(
                PartitionPrimeNumbers::partitionPrimesWithCustomCollector) + " msecs");
        System.out.println("Partitioning done in: " + execute(PartitionPrimeNumbers::partitionPrimesWithInlineCollector) + " msecs");
    }

    private static long execute(Consumer<Integer> primePartitioner) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; ++i) {
            long start = System.nanoTime();
            // Partitions the first million natural numbers into primes and non-primes
            primePartitioner.accept(1_000_000);
            // The duration in milliseconds
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                // Checks if this execution is the fastest one
                fastest = duration;
            }
            System.out.println("Fastest execution done in " + fastest + " msecs");
        }
        return fastest;
    }
}
