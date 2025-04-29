package Aston.Lesson14;

public class Factorial {

    public int factorial(int f){
        if (f<0)
            throw new IllegalArgumentException("Факториал не может быть отрицательным");
        int result=1;
        for (int i=2; i<=f; i++){
            result=result*i;
        }
        return result;
    }

}
