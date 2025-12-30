import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector {
    public static void main(String[] args) {

        Supplier<StringBuilder> supplier = StringBuilder::new;

        BiConsumer<StringBuilder, String> accumulator = (sb, s) -> {
            if(sb.length() > 0) sb.append(", ");
            sb.append(s);
        };

        BinaryOperator<StringBuilder> combiner = (sb1, sb2) -> {
            if (sb1.length() > 0 && sb2.length() > 0){
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
                List.of("Java", "Streams", "Rule")
                        .stream()
                        .collect(customCollector);

        System.out.println(result);

    }
}
