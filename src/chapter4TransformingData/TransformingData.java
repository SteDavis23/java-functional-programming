package src.chapter4TransformingData;

import src.utilities.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class TransformingData {

    public static List<Employee> employees = new Employee().generateSomeEmployees();
    private static List<Integer> ages = List.of(1,32,14,22,19,1,14);

    public static void main(String[] args) {
//        double totalNumberOfEmployees = new TransformingData().findAverageNumberOfReportees();
//        System.out.println("Average number of employees: " + totalNumberOfEmployees);
//        System.out.println("Nested employees' names: " + new TransformingData().retrieveAllEmployeesIgnoringHierarchy());
//        Map<Boolean, List<Integer>> partitionedAges = partitionByAgeGreaterThanFifteen();
//        printPartitionByAgeResult(partitionedAges);
//        Map<Boolean, Long> partitionedAgesAndStoreCount = partitionByAgeAndStoreCount();
//        printPartitionByAgeAndStoreCountResult(partitionedAgesAndStoreCount);
        Map<Integer, List<Integer>> groupingByExampleResult = groupingByExampleRefresher();
        groupingByExampleResult.forEach((age, ageList) -> {
            System.out.printf("Age: %d\n", age);
            ageList.forEach(System.out::println);
        });
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

    public static Integer retrieveCountOfAgesLessOrEqualToFifteen(Map<Boolean, Long> partitionedAges) {
        return  partitionedAges.getOrDefault(false, 0L).intValue();
    }

    public static Integer retrieveCountOfAgesGreaterThanFifteen(Map<Boolean, Long> partitionedAges) {
        return partitionedAges.getOrDefault(true, 0L).intValue();
    }

    public static Map<Boolean, Long> partitionByAgeAndStoreCount() {
        return ages.stream()
                .collect(partitioningBy(age -> age > 15, Collectors.counting()));
    }

    public static void printPartitionByAgeResult(Map<Boolean, List<Integer>> partitionedAges) {
        Set<Map.Entry<Boolean, List<Integer>>> mapEntries = partitionedAges.entrySet();
        System.out.println("Partitioned ages around 15 ");
        mapEntries.forEach(System.out::println);
        System.out.println("Ages less than or equal to fifteen: ");
        retrieveAgesLessOrEqualToFifteen(partitionedAges).forEach(System.out::println);
        System.out.println("Ages greater than fifteen: ");
        retrieveAgesGreaterThanFifteen(partitionedAges).forEach(System.out::println);
    }

    private static void printPartitionByAgeAndStoreCountResult(Map<Boolean, Long> partitionedAgesAndStoreCount) {
        Set<Map.Entry<Boolean, Long>> mapEntries = partitionedAgesAndStoreCount.entrySet();
        System.out.println("Partitioned ages around 15 with their counts ");
        mapEntries.forEach(System.out::println);
        System.out.printf("Number of ages less than or equal to fifteen: %d\n", retrieveCountOfAgesLessOrEqualToFifteen(partitionedAgesAndStoreCount));
        System.out.printf("Number of ages greater than fifteen: %d\n", retrieveCountOfAgesGreaterThanFifteen(partitionedAgesAndStoreCount));
    }

    private static Map<Integer, List<Integer>> groupingByExampleRefresher() {
        return ages.stream()
                .collect(groupingBy(age -> age));
    }

}
