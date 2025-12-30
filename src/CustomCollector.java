import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomCollector {
    public static void main(String[] args) {

        Supplier<StringBuilder> supplier = StringBuilder::new;

        BiConsumer<StringBuilder, String> accumulator = (sb, s) -> {
            if(!sb.isEmpty()) sb.append(", ");
            sb.append(s);
        };

        BinaryOperator<StringBuilder> combiner = (sb1, sb2) -> {
            if (!sb1.isEmpty() && !sb2.isEmpty()){
                sb1.append(", ");
            }
            sb1.append(sb2);
            return sb1;
        };

        Function<StringBuilder, String> finisher = StringBuilder::toString;

        Collector<String, StringBuilder, String> customCollector = Collector.of(
                supplier,
                accumulator,
                combiner,
                finisher
        );

        String result =
                Stream.of("Java", "Streams", "Rule")
                        .collect(customCollector);

        System.out.println(result);

    }
}
