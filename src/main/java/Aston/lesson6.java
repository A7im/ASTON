package Aston;

public class lesson6 {

    public static void main(String[] args) {

        Product firstProduct = new Product("Vostro", "19.03.2024", "Dell", "China", 399, true);
        firstProduct.infoAboutProduct();

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung s25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16", "15.09.2024", "Apple", "USA", 1299, false);
        productsArray[2] = new Product("Razer DeathAdder V3", "14.03.2024", "Razer", "USA", 89, true);
        productsArray[3] = new Product("Apple Watch Ultra 3", "25.12.2024", "Apple", "USA", 799, true);
        productsArray[4] = new Product("Bosch Serie 8", "05.05.2024", "Bosch", "Germany", 1599, true);

        Park bigPark = new Park();
        bigPark.addAttraction("Марс", "10:00-18:00", 5);
        bigPark.addAttraction("Юпитер", "11:00-20:00", 7);
        bigPark.parkInfo();

    }

}
