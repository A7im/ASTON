import Aston.Lesson14.ArithmeticsOperators;
import Aston.Lesson14.Compare;
import Aston.Lesson14.Factorial;
import Aston.Lesson14.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Lesson_14_junit_5 {

    Factorial factorialCheck = new Factorial();

    @Test
    void negativeNumberFactorialTest() {
        assertThrows(IllegalArgumentException.class, () -> factorialCheck.factorial(-7));
    }

    @Test
    void zeroNumberFactorialTest() {
        assertEquals(1, factorialCheck.factorial(0));
    }

    @Test
    void positiveNumberFactorialTest() {
        assertEquals(5040, factorialCheck.factorial(7));
    }

    Triangle TriangleCheck = new Triangle();

    @Test
    void positiveTriangleSquareTest() {
        assertEquals(6, TriangleCheck.triangleSquare(3, 4, 5), 0.1);
    }

    @Test
    void negativeTriangleSquareTest() {
        assertThrows(IllegalArgumentException.class, () -> TriangleCheck.triangleSquare(-2, 7, 9));
    }

    private final ArithmeticsOperators operator = new ArithmeticsOperators();

    @Test
    void arithmeticPlus() {

        assertEquals(20, operator.add(8, 12));
    }

    @Test
    void arithmeticDivide() {
        assertEquals(2, operator.divide(8, 4));
    }

    @Test
    void arithmeticDivideByZero() {
        assertThrows(ArithmeticException.class, () -> operator.divide(5, 0));
    }

    @Test
    void arithmeticMultiply() {
        assertEquals(18, operator.multiply(3, 6));
    }

    @Test
    void arithmeticMinus() {
        assertEquals(4, 8, 4);
    }

    private final Compare comparator = new Compare();

    @Test
    void compareBig() {
        assertEquals("7>3", comparator.compare(7, 3));
    }

    @Test
    void compareEqual() {
        assertEquals("5=5", comparator.compare(5, 5));
    }
}