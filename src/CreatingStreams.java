import java.lang.management.ManagementPermission;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) {
        // From list,set

        //Map //also keySet().stream() or values().stream()
        Map<String, Integer> m = Map.of("A", 1, "B", 2);
        m.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

        // Parallel Stream

        // From Arrays = Arrays.stream(..)
        //Primitive Arrays : IntStream intStream = Arrays.stream(nums);
        //Stream.of(arr)   or Stream.of(1,2,3,4,5)
        //Wrong = Stream.of(null)
        //Right = Stream.ofNullable(null)

        //Empty Stream
        Stream<String> empty = Stream.empty();

        //Builder
        Stream<String> stream = Stream.<String>builder()
                .add("A")
                .add("B")
                .build();

        //Infinite Stream
        Stream<Double> randoms = Stream.generate(Math::random)
                .limit(5);
        randoms.forEach(System.out::println);

        Stream<Integer> numbers = Stream.iterate(1, n -> n <= 10, n -> n+1).limit(5);
        numbers.forEach(System.out::println);

        IntStream.range(1, 5).forEach(System.out::println);
        IntStream.rangeClosed(1, 5).forEach(System.out::println);

        //Object -> Primitive
        //list.stream()
        //    .mapToInt(Integer::intValue)
        //    .sum();


        //Primitive -> Object
        //IntStream.range(1, 5)
        //         .boxed()
        //         .collect(Collectors.toList());






    }
}
