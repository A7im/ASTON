package Aston;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private String name;
    private LocalDate dateOfManufacture;
    private String manufacturer;
    private String countryOfManufacture;
    private float price;
    private boolean bookingStatus;

    public Product (String name, String dateOfManufacture, String manufacturer, String countryOfManufacture, float price, boolean bookingStatus){
        this.name = name;
        this.dateOfManufacture = LocalDate.parse(dateOfManufacture, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.manufacturer = manufacturer;
        this.countryOfManufacture = countryOfManufacture;
        this.price = price;
         this.bookingStatus = bookingStatus;

    }

    public void infoAboutProduct(){
        System.out.println("Информация о товаре:");
        System.out.println("Название: " +name);
        System.out.println("Дата производства: " +dateOfManufacture);
        System.out.println("Производитель: " +manufacturer);
        System.out.println("Страна происхождения: " +countryOfManufacture);
        System.out.println("Цена " +price + " $");
        System.out.println("Состояние бронирования: " + (bookingStatus ? "Забронирован" : "Свободен"));

    }
}
