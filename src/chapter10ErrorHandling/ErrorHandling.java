package src.chapter10ErrorHandling;

import src.utilities.Grade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static src.utilities.Grade.generateSomeGrades;

public class ErrorHandling {

    static List<Grade> studentGrades = generateSomeGrades();

    public static void main(String[] args) {
        List<String> studentNamesToFindGrade = List.of("John", "Michael", "Stephen", "Joe");
        List<Double> studentGradeScores = studentNamesToFindGrade.stream()
                .mapToDouble(studentName -> {
                        try {
                            return retrieveStudentGrade(studentName);
                        } catch (Exception exception) {
                            System.out.printf("Exception caught trying to find student's grade for student %s%n", studentName);
                            return 0.0;
                        }
                })
                .boxed()
                .collect(Collectors.toList());
        studentGradeScores.forEach(System.out::println);
    }

    public static Double retrieveStudentGrade(String studentName) {
        Map<String, Double> studentGradesMap = new HashMap<>();
        studentGrades.forEach(grade -> studentGradesMap.put(grade.getName(), grade.getScore()));
        if (studentGradesMap.containsKey(studentName)) {
            return studentGradesMap.get(studentName);
        } else {
            throw new RuntimeException(String.format("Student %s not found", studentName));
        }
    }
}