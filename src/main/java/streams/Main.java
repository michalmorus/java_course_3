package streams;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {

        Supplier<Integer> randomSupplier = new RandomSupplier(10000);
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i< 5; i++) {
            list.add(i);
        }
        list.forEach(System.out::println);

        Stream<Integer> numbers = Stream.iterate(0, n -> n+10);
        numbers.limit(5).forEach(System.out::println);

        Stream<Integer> randomNumbers = Stream.generate(randomSupplier).limit(100);
        System.out.println("has odd numbers " + randomNumbers.anyMatch(integer -> integer % 2 == 0));

        randomNumbers = Stream.generate(randomSupplier).limit(100);
        System.out.println("all is unsigned " + randomNumbers.allMatch(integer -> integer > 0));

        System.out.println("more than 0 less than 1000");
        randomNumbers = Stream.generate(randomSupplier).limit(100);
        Stream<Integer> filtered = randomNumbers.filter(integer -> integer > 0 && integer < 100);
        filtered.forEach(System.out::println);

        randomNumbers = Stream.generate(randomSupplier).limit(100);
        Optional<Integer> min = randomNumbers.min(Integer::compareTo);
        System.out.println("min " + min.get());

        System.out.println("to collection");
        randomNumbers = Stream.generate(randomSupplier).limit(10);
        Collection<Integer> a = randomNumbers.collect(Collectors.toList());
        a.forEach(System.out::println);
    }
}
