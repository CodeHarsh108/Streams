import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndPartitioning {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
        Map<Boolean, List<Integer>> g = list.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println(g);


        System.out.println("========================");
        Map<Boolean, List<Integer>> p = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(p);
    }
}
