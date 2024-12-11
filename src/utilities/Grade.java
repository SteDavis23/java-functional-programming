package src.utilities;

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
}