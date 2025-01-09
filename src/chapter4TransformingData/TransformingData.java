package src.chapter4TransformingData;

import src.utilities.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class TransformingData {

    public static List<Employee> employees = new Employee().generateSomeEmployees();

    public static void main(String[] args) {
        double totalNumberOfEmployees = new TransformingData().findAverageNumberOfReportees();
        System.out.println("Average number of employees: " + totalNumberOfEmployees);
        System.out.println("All employees count: " + new TransformingData().retrieveAllEmployeesIgnoringHierarchy().size());
    }

    public double findAverageNumberOfReportees() {
        return employees.stream()
                .map(Employee::getReportees)
                .mapToDouble(reportees -> reportees.size())
                .average()
                .orElse(0.0);
    }

    private List<Employee> reportees;
    private String name;
    private int age;

    public List<Employee> retrieveAllEmployeesIgnoringHierarchy() {
        return employees.stream()
                .flatMap(employee -> employee.getReportees().stream())
                .collect(Collectors.toList());
    }
}
