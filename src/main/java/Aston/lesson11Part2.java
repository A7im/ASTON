package Aston;

public class lesson11Part2 {
    public static void main(String[] args) {
        iShape[] shapes = {
                new Rectangle(50, 20, "yelow", "red"),
                new Rectangle(20, 10, "black", "white"),
                new Circle(250, "green", "black"),
                new Triangle(9, 4, 6, "orange", "white")
        };

        for (iShape shape : shapes) {
            System.out.println("Форма фигуры: " +shape.getClass().getSimpleName());
            System.out.println("Площадь фигуры: "+shape.getArea());
            System.out.println("Периметр фигуры: "+shape.getPerimeter());
            System.out.println("Цвет фона: "+shape.getFillColor());
            System.out.println("Цвет границы: " +shape.getBorderColor());
            System.out.println();
        }
    }
}
