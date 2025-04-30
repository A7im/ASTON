package Aston.lesson13part2;

public class Lesson13part2 {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();

        directory.add("Obama", "+556633222");
        directory.add("Trump", "+5566332213");
        directory.add("Merkel", "+5566332214");
        directory.add("Merkel", "+5566332215");
        directory.add("Abramovich", "+5566332215");
        directory.add("Abramovich", "332255");

        System.out.println("Obama " + directory.get("Obama"));
        System.out.println("Trump " + directory.get("Trump"));
        System.out.println("Merkel " + directory.get("Merkel"));
        System.out.println("Abramovich " + directory.get("Abramovich"));


    }

}
