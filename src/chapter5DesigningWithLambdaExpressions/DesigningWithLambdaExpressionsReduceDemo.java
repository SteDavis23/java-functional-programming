package src.chapter5DesigningWithLambdaExpressions;

import src.utilities.Employee;
import src.utilities.Grade;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class DesigningWithLambdaExpressionsReduceDemo {
    static List<Employee> employees = new Employee().generateSomeEmployees();

    Function<Employee, Employee> parseEmployee;


    public DesigningWithLambdaExpressionsReduceDemo(Function<Employee, Employee> function) {
        this.parseEmployee = function;
    }

    // chains / converts a sequence of functions into 1 function which recursively invokes the next function
    public void setFunctions(Function<Employee, Employee>... functions) {
        this.parseEmployee = Stream.of(functions)
                .reduce((currentFunction, nextFunction) -> currentFunction.andThen(nextFunction))
                .orElse(currentFunction -> currentFunction);
    }

    public static void main(String[] args) {
        DesigningWithLambdaExpressionsReduceDemo demo = new DesigningWithLambdaExpressionsReduceDemo((employee) -> {
            return employee.getReportees().stream()
                    .findFirst()
                    .orElse(employee);
        });

        Function<Employee, Employee> func1 = (employee) -> employee.getReportees().stream().findAny().orElse(employee);
        Function<Employee, Employee> func2 = (employee) -> employee.getReportees().stream().findFirst().orElse(employee);

        demo.setFunctions(func1, func2);

        System.out.println(demo.parseEmployee.apply(employees.stream().findFirst().orElse(new Employee())));
    }
}