package src.chapter11RefactoringToFunctionalProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    Factorial factorial;

    @BeforeEach
    public void init() {
        factorial = new Factorial();
    }

    @Test
    public void testComputeFactorial() {
        assertAll(() -> assertEquals(BigInteger.ONE, factorial.compute(1)),
                () -> assertEquals(BigInteger.TWO, factorial.compute(2)),
                () -> assertEquals(BigInteger.valueOf(6), factorial.compute(3)),
                () -> assertEquals(BigInteger.valueOf(120), factorial.compute(5))
        );
    }

    @Test
    public void testComputeFunctionalStyle() {
        assertAll(() -> assertEquals(BigInteger.ONE, factorial.computeFunctionalStyle(1)),
                () -> assertEquals(BigInteger.TWO, factorial.computeFunctionalStyle(2)),
                () -> assertEquals(BigInteger.valueOf(6), factorial.computeFunctionalStyle(3)),
                () -> assertEquals(BigInteger.valueOf(120), factorial.computeFunctionalStyle(5))
        );
    }

    @Test
    public void testComputeFunctionalStyleSolution() {
        assertAll(() -> assertEquals(BigInteger.ONE, factorial.computeFunctionalStyleSolution(1)),
                () -> assertEquals(BigInteger.TWO, factorial.computeFunctionalStyleSolution(2)),
                () -> assertEquals(BigInteger.valueOf(6), factorial.computeFunctionalStyleSolution(3)),
                () -> assertEquals(BigInteger.valueOf(120), factorial.computeFunctionalStyleSolution(5))
        );
    }
}
