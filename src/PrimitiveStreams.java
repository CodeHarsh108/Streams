import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        //IntStream
        int sum = IntStream.range(1, 10)
                .sum();
        System.out.println("Sum : " + sum);

        IntStream.of(1,2,3,4,5)
                .average()
                .ifPresent(avg -> System.out.println("Average : " + avg));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(max -> System.out.println("Max : " + max));

        //DoubleStream - same

        //Stats
        IntSummaryStatistics stats = IntStream.range(1, 10).summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());


    }
}
