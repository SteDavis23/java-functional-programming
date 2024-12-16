package src.chapter3StringsComparatorsFiles;

import src.utilities.Grade;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExamples {
    List<Grade> grades = List.of(
            new Grade("Stephen", 80.0),
            new Grade("John", 32.0),
            new Grade("Mark", 80.0),
            new Grade("Leo", 47.0),
            new Grade("Pan", 47.0)
    );

    public static void main(String[] args) {
        Map<Double, List<Grade>> peopleGroupedByAge = new GroupingByExamples().groupPeopleByAge();
        Map<Double, List<String>> namesGroupedByAge = new GroupingByExamples().groupNamesByAge();
    }

    private Map<Double, List<Grade>> groupPeopleByAge() {
        Map<Double, List<Grade>> peopleGroupedByAgeAsMap = grades.stream()
                .collect(Collectors.groupingBy(Grade::getScore));
        System.out.println("Printing people grouped by age as group:\n" + peopleGroupedByAgeAsMap);
        System.out.println("Type of grouped data structure: " + peopleGroupedByAgeAsMap.getClass());
        return peopleGroupedByAgeAsMap;
    }

    private Map<Double, List<String>> groupNamesByAge() {
        Map<Double, List<String>> namesGroupedByAgeAsMap = grades.stream()
                .collect(Collectors.groupingBy(
                        Grade::getScore,
                        Collectors.mapping(Grade::getName, Collectors.toList())
                ));
        System.out.println("\nPrinting names grouped by age as group:\n" + namesGroupedByAgeAsMap);
        System.out.println("Type of grouped data structure: " + namesGroupedByAgeAsMap.getClass());
        return namesGroupedByAgeAsMap;
    }
}
