package src.chapter11RefactoringToFunctionalProgramming;//package src.chapter10ErrorHandling;

import java.math.BigInteger;

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

}