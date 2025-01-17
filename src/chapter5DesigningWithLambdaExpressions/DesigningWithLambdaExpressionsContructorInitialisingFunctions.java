package src.chapter5DesigningWithLambdaExpressions;

import src.utilities.Grade;

import java.util.List;
import java.util.function.Function;

public class DesigningWithLambdaExpressionsContructorInitialisingFunctions {
    static List<Grade> grades = List.of(new Grade("Stephen", 80.0), new Grade("John", 32.0), new Grade("Mark", 79.9));

    Function<Double, Double> sumGradesAroundPassRate;
    Function<Double, Boolean> isSumOfTargetGradesBetterThanNationalAverage;

    public DesigningWithLambdaExpressionsContructorInitialisingFunctions(Function<Double, Boolean> dynamicFunction1, Function<Double, Double> dynamicFunction2) {
        this.isSumOfTargetGradesBetterThanNationalAverage = dynamicFunction1;
        this.sumGradesAroundPassRate = dynamicFunction2;
    }

    public static void main(String[] args) {
        DesigningWithLambdaExpressionsContructorInitialisingFunctions designingWithLambdaExpressions1 = new DesigningWithLambdaExpressionsContructorInitialisingFunctions((sum) -> sum > 70.0, (passRate) -> grades.stream()
                .filter(grade -> grade.getScore() > passRate)
                .mapToDouble(Grade::getScore)
                .sum());

        DesigningWithLambdaExpressionsContructorInitialisingFunctions designingWithLambdaExpressions2 = new DesigningWithLambdaExpressionsContructorInitialisingFunctions((sum) -> sum < 70.0, (passRate) -> grades.stream()
                .filter(grade -> grade.getScore() < passRate)
                .mapToDouble(Grade::getScore)
                .sum());

        double passRate = 70.0;
        System.out.println("Sum of grades that did pass\n" + designingWithLambdaExpressions1.sumGradesAroundPassRate.apply(passRate));
        System.out.println("Sum of grades that failed\n" + designingWithLambdaExpressions2.sumGradesAroundPassRate.apply(passRate));

        System.out.println("Did sum of grades that passed outperform national average?\n"
                + designingWithLambdaExpressions1.isSumOfTargetGradesBetterThanNationalAverage.apply(designingWithLambdaExpressions1.sumGradesAroundPassRate.apply(passRate))
        );
        System.out.println("Did sum of grades that failed underperform national average?\n"
                + designingWithLambdaExpressions2.isSumOfTargetGradesBetterThanNationalAverage.apply(designingWithLambdaExpressions2.sumGradesAroundPassRate.apply(passRate))
        );
    }
}