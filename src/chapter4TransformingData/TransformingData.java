package src.chapter4TransformingData;

import src.utilities.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

public class TransformingData {

    public static List<Employee> employees = new Employee().generateSomeEmployees();
    private static List<Integer> ages = List.of(1,32,14,22,19);

    public static void main(String[] args) {
//        double totalNumberOfEmployees = new TransformingData().findAverageNumberOfReportees();
//        System.out.println("Average number of employees: " + totalNumberOfEmployees);
//        System.out.println("Nested employees' names: " + new TransformingData().retrieveAllEmployeesIgnoringHierarchy());
         Map<Boolean, List<Integer>> partitionedAges = partitionByAgeGreaterThanFifteen();
         Set<Map.Entry<Boolean, List<Integer>>> mapEntries = partitionedAges.entrySet();
        System.out.println("Partitioned ages around 15 ");
         mapEntries.forEach(System.out::println);
         System.out.println("Ages less than or equal to fifteen: ");
         retrieveAgesLessOrEqualToFifteen(partitionedAges).forEach(System.out::println);
        System.out.println("Ages greater than fifteen: ");
         retrieveAgesGreaterThanFifteen(partitionedAges).forEach(System.out::println);
        }

    public double findAverageNumberOfReportees() {
        return employees.stream()
                .map(Employee::getReportees)
                .mapToDouble(reportees -> reportees.size())
                .average()
                .orElse(0.0);
    }

    public static Map<Boolean, List<Integer>> partitionByAgeGreaterThanFifteen() {
        return ages.stream()
                .collect(partitioningBy(age -> age > 15));
    }

    public static List<Integer> retrieveAgesLessOrEqualToFifteen(Map<Boolean, List<Integer>> partitionedAges) {
        return partitionedAges.get(false);
    }

    public static List<Integer> retrieveAgesGreaterThanFifteen(Map<Boolean, List<Integer>> partitionedAges) {
        return partitionedAges.get(true);
    }


}
