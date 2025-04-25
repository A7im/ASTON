package Aston;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isHungry = true;
    public Cat(String name) {
        super(150, 0, name);
        catCount++;

    }
    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isHungry = false;
            System.out.println(name + " поел из миски и сыт");
        } else {
            System.out.println(name + " не смог поесть - в миске недостаточно еды");
        }
    }

    public boolean isHungry() {
        return isHungry;
    }

    public static int getCatCount() {
        return catCount;
    }

    static class Bowl {
        private int foodAmount;

        public Bowl(int food) {
            if (food < 0)
                System.out.println("Еда не может быть отрицательным");
            this.foodAmount = food;

        }

        public boolean decreaseFood(int amount) {
            if (amount <= 0) {
                System.out.println("Кол-во еды должно быть положительным");
                return false;
            }
            if (foodAmount >= amount) {
                foodAmount -= amount;
                return true;
            }
            return false;
        }

        public void addFood(int amount) {
            if (amount > 0) {
                foodAmount += amount;
                System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
            } else {
                System.out.println("Нельзя добавить отрицательное количество еды");
            }
        }

        public int getFoodAmount() {
            return foodAmount;
        }
    }
}

