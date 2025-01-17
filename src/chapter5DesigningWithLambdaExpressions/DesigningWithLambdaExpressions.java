package src.chapter5DesigningWithLambdaExpressions;

import src.utilities.Grade;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Learning about Predicate<T> and Function<T, R>
// higher order functions means instead of saving the methods in a class, pass in the method logic
// to the class calling this method, with this class having a constructor to initialise this function by initialising
// the Function<T, R> field of the class
// This allows us to make the function logic passed to the class dynamic, it can perform any logic we like
// old way is to define a bunch of methods, by passing in lambda expression we use lazy loading
// by passing in lambda expressions to constructors, we don't need to Autowire in or import classes with these
// method definitions
public class DesigningWithLambdaExpressions {
    List<Grade> grades = List.of(new Grade("Stephen", 80.0), new Grade("John", 32.0), new Grade("Mark", 79.9));

    public static void main(String[] args) {
        System.out.println("Demo of repetitive code");
        System.out.println(new DesigningWithLambdaExpressions().filterGradesByScoreGreaterThan50());
        System.out.println(new DesigningWithLambdaExpressions().filterGradesForStephen());

        System.out.println("Demo of passing lambda expressions with reduced code");
        System.out.println(new DesigningWithLambdaExpressions().filterGradesByCondition(grade -> grade.getScore() > 50.0));
        System.out.println(new DesigningWithLambdaExpressions().filterGradesByCondition(grade -> grade.getName().equals("Stephen")));
    }

    public List<Grade> filterGradesByScoreGreaterThan50() {
        return grades.stream()
                .filter(grade -> grade.getScore() > 50.0)
                .collect(Collectors.toList());
    }

    public List<Grade> filterGradesForStephen() {
        return grades.stream()
                .filter(grade -> grade.getName().equals("Stephen"))
                .collect(Collectors.toList());
    }

    public List<Grade> filterGradesByCondition(Predicate<Grade> filterLogic) {
        return grades.stream()
                .filter(filterLogic)
                .collect(Collectors.toList());
    }

    // todo: examples using Function(T,R) as a parameter to constructors
    // this extracts logic from method to class level

    // todo: example of stream filtering where price > 10, a different stream for price > 4
    // a different stream for name == "Stephen"
    // how can you cover all cases with 1 method - hint, take in a parameter



}