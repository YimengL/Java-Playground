package mjia.ch06;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        // Creates the collection operation starting point
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        // Accumulates the traversed item, modifying the accumulator in place
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        // Modifies the first accumulator, combining it with the content of the second one
        // Returns the modified first accumulator
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        // Identifies function
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        // Flags the collector as IDENTITY_FINISH and CONCURRENT
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
