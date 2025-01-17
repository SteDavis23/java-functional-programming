package src.chapter5DesigningWithLambdaExpressions;

import src.utilities.Grade;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DesigningWithLambdaExpressions {
    static List<Grade> grades = List.of(new Grade("Stephen", 80.0), new Grade("John", 32.0), new Grade("Mark", 79.9));

    Function<Double, Double> sumGradesGreaterThanPassRate = (passRate) -> {
        return grades.stream()
                .filter(grade -> grade.getScore() > passRate)
                .mapToDouble(Grade::getScore)
                .sum();
    };

    Function<Double, Boolean> isSumGreaterThanHardcodedNationalAverage = (sum) -> {
        return sum > 70.0;
    };

    BiFunction<Double, Double, Boolean> isSumGreaterThanNationalAverageDynamic = (sum, nationalAverage) -> {
        return sum > nationalAverage;
    };

    public DesigningWithLambdaExpressions() {

    }

    public static void main(String[] args) {
        DesigningWithLambdaExpressions designingWithLambdaExpressions = new DesigningWithLambdaExpressions();
        System.out.println("Calling functional interface\nTotal scores: " + designingWithLambdaExpressions.sumGradesGreaterThanPassRate.apply(50.0));
        System.out.println("Calling nested functional interface\nIs greater than national average: "
                        + new DesigningWithLambdaExpressions().isSumGreaterThanNationalAverageDynamic.apply(designingWithLambdaExpressions
                                .sumGradesGreaterThanPassRate.apply(50.0),
                        70.0
                )
        );

        System.out.println("Calling functional interface\nTotal scores: " + new DesigningWithLambdaExpressions().sumGradesGreaterThanPassRate.apply(50.0));
        System.out.println("Calling nested functional interface\nIs greater than national average: "
                + designingWithLambdaExpressions.isSumGreaterThanNationalAverageDynamic.apply(designingWithLambdaExpressions
                        .sumGradesGreaterThanPassRate.apply(50.0),
                    70.0
                )
        );

        Function<Double, Boolean> chainedFunctionToGetSumAndThenCheckVsNationalAverage = designingWithLambdaExpressions.sumGradesGreaterThanPassRate.andThen(designingWithLambdaExpressions.isSumGreaterThanHardcodedNationalAverage);
        System.out.println("Calling chained functions using andThen\n" + chainedFunctionToGetSumAndThenCheckVsNationalAverage.apply(50.0));


        System.out.println("Calling chained functions without temporary variable using andThen\n" +
                designingWithLambdaExpressions.isSumGreaterThanHardcodedNationalAverage.apply(designingWithLambdaExpressions.sumGradesGreaterThanPassRate.apply(50.0))
        );
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
}