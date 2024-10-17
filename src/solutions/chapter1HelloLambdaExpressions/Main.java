package src.solutions.chapter1HelloLambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<Integer> prices = List.of(10, 30, 17, 20, 18, 45, 12);
//        System.out.println("Total discounted price: " + getTotalWith10PercentDiscount(prices));
//        List<String> names = List.of("Stephen", "Nathan", "Hugo", "Natalie");
//        System.out.println(getNamesBeginningWithN(names));
//        System.out.println(skipFirstFourValues(prices));
//        System.out.println(onlyIterateOverFirstThreeElements(prices));
//        System.out.println(iterateUntilConditionIsMet(prices));
//        System.out.println(skipUntilConditionIsMet(prices));

        handlePrices();
        handlePricesEfficiently();
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


    public static void handlePrices() {
        System.out.println("Handling prices inefficiently");
        List<Integer> prices = new ArrayList<Integer>();
        prices.add(2);
        prices.add(5);
        prices.add(10);
        prices.add(11);
        prices.add(14);
        prices.add(15);

        System.out.println("All prices " + prices);

        List<Integer> pricesLessThanNine = prices.stream()
                .filter(price -> price < 9)
                .collect(Collectors.toList());

        System.out.println("Prices < 9");
        pricesLessThanNine.stream()
                .forEach(System.out::println);

        List<Integer> pricesLessThanTwelve = prices.stream()
                .filter(price -> price < 12)
                .collect(Collectors.toList());

        System.out.println("Prices < 12");
        pricesLessThanTwelve.stream()
                .forEach(System.out::println);

        List<Integer> pricesLessThan16 = prices.stream()
                .filter(price -> price < 16)
                .collect(Collectors.toList());

        System.out.println("Prices < 16");
        pricesLessThan16.stream()
                .forEach(System.out::println);

    }

    public static void handlePricesEfficiently() {
        System.out.println("Handling prices efficiently");

        List<Integer> prices = new ArrayList<Integer>();
        prices.add(2);
        prices.add(5);
        prices.add(10);
        prices.add(11);
        prices.add(14);
        prices.add(15);

        System.out.println("Original prices: " + prices);

        List<Integer> pricesLessThanNine = prices.stream()
                .filter(handlePricesEfficientlyPredicateHelper(9))
                .collect(Collectors.toList());

        System.out.println("Prices less than 9");
        pricesLessThanNine.forEach(System.out::println);

        List<Integer> pricesLessThanTwelve = prices.stream()
                .filter(handlePricesEfficientlyPredicateHelper(12))
                .collect(Collectors.toList());

        System.out.println("Prices less than 12");
        pricesLessThanTwelve.forEach(System.out::println);

        List<Integer> pricesLessThanSixteen = prices.stream()
                .filter(handlePricesEfficientlyPredicateHelper(16))
                .collect(Collectors.toList());

        System.out.println("Prices less than 16");
        pricesLessThanSixteen.forEach(System.out::println);
    }

    public static Predicate<Integer> handlePricesEfficientlyPredicateHelper(Integer priceToBeLessThan) {
        return price -> price < priceToBeLessThan;
    }
}
