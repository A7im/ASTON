import Aston.Lesson14.ArithmeticsOperators;
import Aston.Lesson14.Compare;
import Aston.Lesson14.Factorial;
import Aston.Lesson14.Triangle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Lesson_14_testng {

    private final Factorial factorialCheck = new Factorial();

    @Test
    public void zeroNumberFactorialTest() {
        assertEquals(factorialCheck.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeNumberFactorialTest() {
        factorialCheck.factorial(-1);
    }

    @Test
    public void positiveNumberFactorialTest() {
        assertEquals(factorialCheck.factorial(5), 120);
    }

    private final Triangle TriangleCheck = new Triangle();

    @Test
    public void positiveTriangleSquareTest() {
        assertEquals(TriangleCheck.triangleSquare(3, 4, 5), 6.0, 0.01);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeTriangleSquareTest() {
        TriangleCheck.triangleSquare(-1, 2, 3);
    }

    private final ArithmeticsOperators operator = new ArithmeticsOperators();

    @Test
    public void arithmeticPlus() {
        assertEquals(operator.add(2, 3), 5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void arithmeticDivideByZero() {

        operator.divide(5, 0);
    }

    @Test
    void arithmeticDivide() {
        assertEquals(operator.divide(8, 4), 2);
    }

    @Test
    void arithmeticMultiply() {
        assertEquals(operator.multiply(3, 6), 18);
    }

    @Test
    void arithmeticMinus() {
        assertEquals(operator.minus(7, 18), -11);
    }

    private final Compare comparator = new Compare();

    @Test
    void compareBig() {
        assertEquals(comparator.compare(12, 5), "12>5");
    }

    @Test
    void compareEqual() {
        assertEquals(comparator.compare(12, 12), "12=12");
    }
}