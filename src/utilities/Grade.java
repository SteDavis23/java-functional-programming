package src.utilities;

import java.util.List;

public class Grade {
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

    public String toString() {
        return "Name: " + name + "\nScore: " + score;
    }

    public static List<Grade> generateSomeGrades() {
        return List.of(new Grade("John", 90.0),
        new Grade("Stephen", 47.2));
    }
}