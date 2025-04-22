package Aston;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isHungry = true;

    public Cat(String name) {
        super(150, 0, name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isHungry = false;
            System.out.println(name + " поел из миски и сыт");
        } else {
            System.out.println(name + " не смог поесть - в миске недостаточно еды");
        }
    }

}


