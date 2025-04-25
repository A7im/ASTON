package Aston;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Сёма");
        Cat cat2 = new Cat("Тёма");

        cat1.run(150);
        cat1.swim(0);

        cat2.run(50);
        cat2.swim(5);

        Dog dog = new Dog("Граф");
        Dog dog1 = new Dog("Рекс");

        dog.run(400);
        dog.swim(5);

        dog1.run(-5);
        dog1.swim(-2);

        System.out.println("Кол-во животных: " + Animal.getAnimalCount() + " шт.");
        System.out.println("Кол-во котов: " + Cat.getCatCount() + " шт.");
        System.out.println("Кол-во собак: " + Dog.getDogCount() + " шт.");

        Bowl bowl = new Bowl(40);
        List<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        System.out.println("Кормим котов: ");
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        System.out.println("Сытость котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + !cat.isHungry());
        }

        System.out.println("Добавим еще еды в миску:");
        bowl.addFood(5);
        for (Cat cat : cats) {
            if (cat.isHungry()) {
                cat.eat(bowl, 15);
            }

        }

    }

}