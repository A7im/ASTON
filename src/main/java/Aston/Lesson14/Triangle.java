package Aston.Lesson14;

public class Triangle {
    public double triangleSquare(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException("Стороны не могут быть отрицательными");
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("Невалидный треугольник");
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}
