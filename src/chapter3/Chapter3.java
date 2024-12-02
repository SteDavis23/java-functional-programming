package src.chapter3;

import java.util.List;
import java.util.Optional;

public class Chapter3 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Optional<String> firstFailedStudent = new Chapter3().optionalExample();
        System.out.println("Somebody who failed the exam is: " + firstFailedStudent.orElse("Nobody failed the exam!"));
    }

    private Optional<String> optionalExample() {
        List<Grade> grades = List.of(new Grade("Stephen", 80.0), new Grade("John", 32.0), new Grade("Mark", 79.9));
        Optional<Grade> optionalFirstFailedGrade = grades.stream()
                .filter(grade -> grade.getScore() < 40)
                .findFirst();
        return optionalFirstFailedGrade.map(Grade::getName);
    }

    private class Grade {
        private String name;
        private double score;

        public Grade(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public double getScore() {
            return score;
        }
    }
}
