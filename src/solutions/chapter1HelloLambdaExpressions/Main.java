package src.solutions.chapter1HelloLambdaExpressions;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> prices = List.of(10, 30, 17, 20, 18, 45, 12);
        System.out.println("Total discounted price: " + getTotalWith10PercentDiscount(prices));
        List<String> names = List.of("Stephen", "Nathan", "Hugo", "Natalie");
        System.out.println(getNamesBeginningWithN(names));
        System.out.println(skipFirstFourValues(prices));
        System.out.println(onlyIterateOverFirstThreeElements(prices));
        System.out.println(iterateUntilConditionIsMet(prices));
        System.out.println(skipUntilConditionIsMet(prices));
    }

    // Get the prices for all the tickers,
    // find the prices that are less than $500,
    // and total the net asset value of only the stocks that make the cut.
    public static double getTotalWith10PercentDiscount(List<Integer> prices) {
        return prices.stream()
                .filter((price) -> price > 20)
                .mapToDouble((price) -> price * .90)
                .sum();
    }

    public static List<String> getNamesBeginningWithN(List<String> names) {
        return names.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
    }

    // skip first 4 values - skip(), same as beginning iteration at i = 5
    public static List<Integer> skipFirstFourValues(List<Integer> prices) {
        System.out.println("Original list: " + prices);
        System.out.println("Skipping first 4 values");
        return prices.stream()
                .skip(4)
                .collect(Collectors.toList());
    }

    // only iterate over first 3 elements, same as i < 3
    public static List<Integer> onlyIterateOverFirstThreeElements(List<Integer> prices) {
        System.out.println("Original list: " + prices);
        System.out.println("First 3 elements:");
        return prices.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    // iterate until price > 30 - like using a break
    public static List<Integer> iterateUntilConditionIsMet(List<Integer> prices) {
        System.out.println("Original list: " + prices);
        System.out.println("Iterating until price > 30:");
        return prices.stream()
                .takeWhile((price) -> price <= 30)
                .collect(Collectors.toList());
    }

    // skip until price > 30 - like using a continue
    public static List<Integer> skipUntilConditionIsMet(List<Integer> prices) {
        System.out.println("Original list: " + prices);
        System.out.println("Skipping until price > 30:");
        return prices.stream()
                .dropWhile((price) -> price <= 30)
                .collect(Collectors.toList());
    }


}
