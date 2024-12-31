package mjia.ch06;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionPrimeNumbers {
    public static void main(String[] args) {
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimesWithCustomCollector(100));
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        // return primes.stream().noneMatch(i -> candidate % i == 0);
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream().takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return () -> new HashMap<Boolean, List<Integer>>() {{
                // Starts the collection process with a Map containing two empty Lists
                put(true, new ArrayList<Integer>());
                put(false, new ArrayList<Integer>());
            }};
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
                // Gets the list of prime or nonprime numbers depending on the result of isPrime
                // Adds the candidate to the appropriate list
                acc.get(isPrime(acc.get(true), candidate)).add(candidate);
            };
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
            };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            // No transformation necessary at the end of the collection process, so terminate it with identity function
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            // This collector is IDENTITY_FINISH but neither UNORDERED nor CONCURRENT because it relies on the fact
            // that prime numbers are discovered in sequence
            return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
        }
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithInlineCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(
                // Supplier
                () -> new HashMap<Boolean, List<Integer>>() {{
                    put(true, new ArrayList<Integer>());
                    put(false, new ArrayList<Integer>());
                }},
                // Accumulator
                (acc, candidate) -> {
                    acc.get(isPrime(acc.get(true), candidate)).add(candidate);
                },
                // Combiner
                (map1, map2) -> {
                    map1.get(true).addAll(map2.get(true));
                    map1.get(false).addAll(map2.get(false));
                });
    }

}
