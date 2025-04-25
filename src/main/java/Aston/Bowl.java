package Aston;

class Bowl {
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

