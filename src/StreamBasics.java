import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {
    public static void main(String[] args) {
        // Source Creation
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date");

        //Stream from collection
        Stream<String> fruitStream = fruits.stream();

        //Stream from array
        String[] fruitsArray = {"apple", "banana"};
        Stream<String> arrayStream = Arrays.stream(fruitsArray);

        //Stream of values
        Stream<String> directStream = Stream.of("apple", "banana", "cherry");

        //Pipeline
        List<String> result  = fruits.stream()
                .filter(f -> f.length() > 5)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Filtered Fruits : " + result);

        //Lazy Evaluation demo
        Stream<String> lazy = fruits.stream()
                .filter(f -> {
                    System.out.println("Filtering" + f);
                    return f.startsWith("a");
                })
                .map(f -> {
                    System.out.println("Mapping " + f);
                    return f.toUpperCase();
                });
        System.out.println("Lazy...zzzzzzzzzzz.......");
        lazy.forEach(System.out::println);
    }
}