package Aston;

import java.util.ArrayList;

public class Park {
    ArrayList<Attraction> attractions = new ArrayList<>();

    public static class Attraction {
        String workTime, name;
        float price;

    }

    public void addAttraction(String name, String workTime, float price) {
        Attraction newAttraction = new Attraction();
        newAttraction.name = name;
        newAttraction.workTime = workTime;
        newAttraction.price = price;
        this.attractions.add(newAttraction);

    }

    public void parkInfo() {
        for (Attraction any : attractions) {
            System.out.println("Аттракцион: " + any.name);
            System.out.print("Работает: " + any.workTime + " ");
            System.out.println("Цена билета: " + any.price + " руб.");

        }

    }

}
