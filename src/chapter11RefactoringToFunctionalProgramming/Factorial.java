package src.chapter11RefactoringToFunctionalProgramming;//package src.chapter10ErrorHandling;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Factorial {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public BigInteger compute(long number) {
        BigInteger solution = BigInteger.ONE;
        for (int i=1; i<=number; i++) {
            solution = solution.multiply(BigInteger.valueOf(i));
        }
        return solution;
    }

    public BigInteger computeFunctionalStyle(long number) {
        BigInteger beginningValue = BigInteger.ONE;
        return LongStream.rangeClosed(1, number)
                .mapToObj(val -> BigInteger.valueOf(val))
                .reduce((val1, val2) -> val1.multiply(val2))
                .orElse(BigInteger.ONE);
    }

    public BigInteger computeFunctionalStyleSolution(long number) {
        return LongStream.rangeClosed(1, number)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .orElse(BigInteger.ONE);
    }

    public static BigInteger multiplyNumbers(BigInteger beginningValue, BigInteger factor) {
        return beginningValue.multiply(factor);
    }

}