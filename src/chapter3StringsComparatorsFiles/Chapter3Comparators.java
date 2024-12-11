package src.chapter3StringsComparatorsFiles;

import src.utilities.Grade;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter3Comparators {

    List<Grade> grades = List.of(new Grade("Stephen", 80.0), new Grade("John", 32.0), new Grade("Mark", 79.9));

    public static void main(String[] args) {
        System.out.println("Printing grades in descending score using lambda expressions");
        List<Grade> gradesInDescendingScore = new Chapter3Comparators().sortGradesInDescendingScore();
        gradesInDescendingScore.forEach(System.out::println);

        System.out.println("\nPrinting grades in ascending score using lambda expressions");
        List<Grade> gradesInAscendingScore = new Chapter3Comparators().sortGradesInAscendingScore();
        gradesInAscendingScore.forEach(System.out::println);

        System.out.println("\nPrinting grades in ascending score using Custom comparator (old way)");
        List<Grade> gradesInAscendingScoreOldWay = new Chapter3Comparators().sortGradesInAscendingScoreOldWay();
        gradesInAscendingScoreOldWay.forEach(System.out::println);
    }

    public List<Grade> sortGradesInDescendingScore() {
        return grades.stream()
                .sorted((grade1, grade2) -> Double.compare(grade2.getScore(), grade1.getScore()))
                .collect(Collectors.toList());
    }

    public List<Grade> sortGradesInAscendingScore() {
        return grades.stream()
                .sorted((grade1, grade2) -> Double.compare(grade1.getScore(), grade2.getScore()))
                .collect(Collectors.toList());
    }

    public List<Grade> sortGradesInAscendingScoreOldWay() {
        return grades.stream()
                .sorted(new Comparator<Grade>() {
                    @Override
                    public int compare(Grade g1, Grade g2) {
                        return Double.compare(g1.getScore(), g2.getScore());
                    }
                })
        .collect(Collectors.toList());
    }

}
