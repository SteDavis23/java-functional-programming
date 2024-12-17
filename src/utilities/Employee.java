package src.utilities;

import java.util.List;

public class Employee {
    private List<Employee> reportees;
    private String name;
    private int age;

    public Employee() {
        this.reportees = List.of();
        this.name = "Rupert";
        this.age = 29;
    }

    public Employee(List<Employee> reportees, String name, int age) {
        this.reportees = reportees;
        this.name = name;
        this.age = age;
    }

    public List<Employee> getReportees() {
        return this.reportees;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public List<Employee> generateSomeEmployees() {
        Employee employee1 = new Employee(List.of(), "Stephen", 27);
        Employee employee2 = new Employee(List.of(), "John", 30);
        Employee employee3 = new Employee(List.of(), "Gabe", 42);
        Employee employee4 = new Employee(List.of(employee1, employee2, employee3), "Michael", 32);
        Employee employee5 = new Employee(List.of(employee4), "Gary", 23);
        return List.of(employee4, employee5);
    }
}
