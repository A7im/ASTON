package Aston;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(500, 10, name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

}
