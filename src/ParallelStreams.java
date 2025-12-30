import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(1, 1000000)
                .boxed()
                .toList();

        //Sequential Stream
        long startTime = System.currentTimeMillis();
        long sequentialSum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;

        //Parallel Stream
        startTime = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()  
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long parallelTime = System.currentTimeMillis() - startTime;

        System.out.println("Sequential sum: " + sequentialSum + " in " + sequentialTime + "ms");
        System.out.println("Parallel sum: " + parallelSum + " in " + parallelTime + "ms");
    }
}
