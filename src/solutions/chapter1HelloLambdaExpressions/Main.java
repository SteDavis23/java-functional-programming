package src.solutions.chapter1HelloLambdaExpressions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world - chapter 1!");

        List<Integer> prices = List.of(10, 30, 17, 20, 18, 45, 12);
        System.out.println("Total discounted price: " + getTotalWith10PercentDiscount(prices));
    }

    // “Get the prices for all the tickers,
    // find the prices that are less than $500,
    // and total the net asset value of only the stocks that make the cut.”
    public static double getTotalWith10PercentDiscount(List<Integer> prices) {
        return prices.stream()
                .filter((price) -> price > 20)
                .mapToDouble((price) -> price * .90)
                .sum();
    }
}
