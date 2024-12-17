package src.chapter4TransformingData;

import src.utilities.Employee;

import java.util.List;

public class TransformingData {

    public static List<Employee> employees = new Employee().generateSomeEmployees();

    public static void main(String[] args) {
        double totalNumberOfEmployees = new TransformingData().findAverageNumberOfReportees();
        System.out.println("Average number of employees: " + totalNumberOfEmployees);
    }

    public double findAverageNumberOfReportees() {
        return employees.stream()
                .map(Employee::getReportees)
                .mapToDouble(reportees -> reportees.size())
                .average()
                .orElse(0.0);
    }
}
