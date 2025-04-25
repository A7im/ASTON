package Aston;

public class Rectangle implements iPolygon {
    private final float length;
    private final float width;
    private final String fillColor;
    private final String borderColor;

    public Rectangle(float length, float width, String fillColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double[] getSides() {
        return new double[]{length, width, length, width};
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
