package Aston;

public class Animal {
    private static int animalCount=0;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected String name;

     public Animal (int maxRunDistance, int maxSwimDistance, String name) {
        this.maxRunDistance=maxRunDistance;
        this.maxSwimDistance=maxSwimDistance;
        this.name = name;
        animalCount++;
     }
     public void run(int runDistance) {
         if (runDistance<=maxRunDistance && runDistance>0)
             System.out.println(name+ " пробежал(а) " +runDistance+ "м.");
         else if (runDistance<0 || runDistance>maxRunDistance) {
             System.out.println("Дистанция не может быть больше " +maxRunDistance + "м. или отрицательным числом");
         }

     }
     public void swim (int swimDistance) {
         if (swimDistance<maxSwimDistance && swimDistance>0)
             System.out.println(name+ " проплыл(а) "+swimDistance + "м.");
         else if (swimDistance<0 || swimDistance>maxSwimDistance)
             System.out.println("Дистанция не может быть больше " +maxSwimDistance + "м. или отрицательным числом");
         else if (swimDistance==0) {
             System.out.println(name+ " Не может плавать!");

         }

     }

    public static int getAnimalCount() {
        return animalCount;
    }

}
