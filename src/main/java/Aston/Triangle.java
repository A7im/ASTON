package Aston;

public class Triangle implements iPolygon {
    private final float a;
    private final float b;
    private final float c;
    private final String fillColor;
    private final String borderColor;

    public Triangle(float a, float b, float c, String fillColor, String bordColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = bordColor;
    }

    @Override
    public double[] getSides() {
        return new double[]{a, b, c};
    }

    @Override
    public double getArea() {
        float halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

}
