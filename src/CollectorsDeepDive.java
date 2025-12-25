import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsDeepDive {
    static class Employee {
        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + "(" + salary + ")";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 60000),
                new Employee("Charlie", "HR", 55000),
                new Employee("David", "IT", 70000),
                new Employee("Eve", "Finance", 80000)
        );
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Department wise : " + byDept);

        Map<Boolean, List<Employee>> highSalary = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
        System.out.println("\nHigh salary (>60K): " + highSalary.get(true));
        System.out.println("Low salary: " + highSalary.get(false));
    }

}
