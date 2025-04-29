package Aston.Lesson14;

public class ArithmeticsOperators {

    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public double divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("делить на ноль нельзя");
        return (double) a / b;

    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
