import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TerminalOperations {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        //Covered = collect foreach

        //reduce
        Optional<String> longest = words.stream()
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2);
        longest.ifPresent(w -> System.out.println("Longest : " + w));

        //count
        Long count= words.stream()
                .filter(w -> w.contains("a"))
                .count();
        System.out.println("Containing a : " + count);

        //all/any/none match
        boolean anyStartsWithA = words.stream()
                .anyMatch(w -> w.startsWith("a"));
        System.out.println("Any starts with a :  " + anyStartsWithA);

        boolean allHaveVowel = words.stream()
                .allMatch(w -> w.matches(".*[aeiou].*"));
        System.out.println("All have vowel : " + allHaveVowel);

    }
}
