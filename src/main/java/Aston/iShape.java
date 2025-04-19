package Aston;

import java.util.Arrays;

public interface iShape {
    double getArea();

    double getPerimeter();

    String getFillColor();

    String getBorderColor();

}

interface iPolygon extends iShape {
    double[] getSides();

    @Override
    default double getPerimeter() {
        return Arrays.stream(getSides()).sum();
    }
}
