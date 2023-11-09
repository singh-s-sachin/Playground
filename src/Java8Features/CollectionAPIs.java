package Java8Features;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionAPIs {

    private static final List<Integer> sampleDataSet;

    private static final Predicate<Integer> isEven = i -> i % 2 == 0;
    private static final BiFunction<Integer, Integer, Integer> getSum = (a, b) -> a + b;
    private static final BiFunction<Collection<Integer>, Integer, Collection<Integer>> getYieldedList = (data, buffer)
            -> data.stream()
            .map(number -> getSum.apply(number, buffer))
            .collect(Collectors.toSet());

    private static final CustomTriFunction<Collection<Integer>, Integer, Integer, List<Integer>> renderData = (dataList, numberToAdd, numberToSubtract)
            -> dataList.stream().map(number -> {
        if (isEven.test(number))
            return number + numberToAdd;
        else
            return number - numberToSubtract;
    }).collect(Collectors.toList());

    private static Consumer<Integer> printMultipleTill10 = (data) -> {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i * data);
        }
    };

    private static Consumer<Integer> convertToOdd = data -> {
        data = isEven.test(data) ? data + 1 : data;
    };
    private static Comparator<Integer> integerComparator = (a, b) -> a - b;

    private static final Function<Integer, Integer> add16 = number -> number + 16;

    static {
        List<Integer> sampleData = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            sampleData.add((int) (i * Math.random() * 1000));
        sampleDataSet = Collections.unmodifiableList(sampleData);
    }

    public static void main(String args[]) {
        System.out.println(":::: DATA ::::\n" + sampleDataSet);
        System.out.println("Distinct Data : " + sampleDataSet.stream().distinct().collect(Collectors.toList()));
        Map<Integer, Boolean> evenIdentified = sampleDataSet.stream().distinct()
                .collect(Collectors.toMap(Function.identity(),
                        number -> isEven.test(number)));
        System.out.println("Even data : " + evenIdentified);
        System.out.println("Yielded data : " + getYieldedList.apply(sampleDataSet, 16));

        Set<Integer> yieldedEvenData = sampleDataSet.stream()
                .filter(isEven)
                .map(add16)
                .collect(Collectors.toSet());

        System.out.println("Yielded Even data : " + yieldedEvenData);
        System.out.println("Sum of 2 number + 16 : " + getSum.andThen(add16).apply(12, 18));
        System.out.println("Add 15 to Even, Subtract 16 from Odd : " + renderData.apply(sampleDataSet, 15, 16));
        System.out.println("Sum of All : " + sampleDataSet.stream().reduce(0, (id, val) -> id + val ));
        sampleDataSet.stream().parallel().forEach(printMultipleTill10);
        System.out.println("Stream reduced to 2 : " + sampleDataSet.stream().limit(2).collect(Collectors.toList()));
        System.out.println("Is all data even : " + sampleDataSet.stream().allMatch(isEven));
        System.out.println("Is any data even : " + sampleDataSet.stream().anyMatch(isEven));
        System.out.println("Maximum : " + sampleDataSet.stream().max(integerComparator).get());
        System.out.println("Minimum : " + sampleDataSet.stream().min(integerComparator).get());
        System.out.println("Sorted : " + sampleDataSet.stream().sorted(integerComparator).collect(Collectors.toList()));
        System.out.println("All data converted to Odd : " + sampleDataSet.stream()
                .mapMulti((data, consumer) -> consumer.accept(isEven.test(data) ? data + 1 : data))
                .collect(Collectors.toList()));
    }
}
