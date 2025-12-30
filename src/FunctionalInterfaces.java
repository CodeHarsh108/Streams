import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        System.out.println("=== Predicate ===");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(9));

        System.out.println("=== Function ===");
        Function<String ,Integer> length = String::length;
        System.out.println(length.apply("Harsh"));

        System.out.println("=== Consumer ===");
        Consumer<String> printer = System.out::println;
        printer.accept("Printer");

        System.out.println("=== Supplier ===");
        Supplier<Double> randomSupplier = Math::random;
        System.out.println(randomSupplier.get() );
    }
}
