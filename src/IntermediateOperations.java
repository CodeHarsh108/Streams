import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperations {
    public static void main(String[] args) {
        //Covered = filter map sorted

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 7, 8);
        //Distinct
        List<Integer> unique = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct : " + unique);

        //limit and skip
        List<Integer> limited = numbers.stream()
                .skip(3)
                .limit(4)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Limit and Skip : " + limited);


        //Flatmap
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d", "e"),
                Arrays.asList("f")
        );

        List<String> flatList = listOfLists.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Flatten list : " + flatList);
    }
}
