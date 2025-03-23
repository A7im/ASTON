package Aston;

public class lesson4 {

    public static void main (String[] args){
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(sumRange(20, 9));
        positiveNegative(0);
        System.out.println(reverseCheckValue(0));
        printNumberString(5, "Nokia, connected people");
        System.out.println(yearLeap(-2004));
    }
    public static void printThreeWords()  { //1 task
    System.out.println(" Orange\n Banana\n Apple\n");
    }
    public static void checkSumSign() { // 2 task
        int a=9, b=8;
        if (a+b>=0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }


    }

    public static void printColor() { //3 task
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (0<=value && value<=100) {
            System.out.println("Желтый");
        }
        else
            System.out.println("Зеленый");

    }

    public static void compareNumbers() { // 4 task
        int a=20, b=75;
        if (a>=b) {
            System.out.println("a>=b");
        }
        else {
            System.out.println("a<b");
        }

    }

    public static boolean sumRange(int a, int b) { // 5 task
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void positiveNegative(int i) { // 6 task
        if (i>=0)
            System.out.println("Положительное число");
        else
            System.out.println("Отрицательное число");
    }

    public static boolean reverseCheckValue(int i) { // 7 task
        return i<0;
    }

    public static void printNumberString(int a, String b) {  // 8 task
        for (int i=0; i<a; i++) {
            System.out.println(b);
        }

    }

    public static boolean yearLeap (int year) { // 9 task
        if (year<-45) {
            System.out.println("Високосный год введен с 45 года до н.э.");
            return false;
        }
        return (year %4==0 && year %100!=0 || year %400==0) ;
    }


}
