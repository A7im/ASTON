package Aston;

import static Aston.Array.sumArray;

public class Lesson12 {

    public static void main(String[] args) {
        String[][] firstArray = {{"5", "7", "12", "1"},
                {"5", "7", "12", "1"},
                {"5", "7", "12", "1"},
                {"5", "7", "12"}};

        String[][] secondArray = {{"5", "7", "12", "1"},
                {"5", "7", "12", "1"},
                {"5", "7", "12", "1"},
                {"5", "7", "ххх", "1"}};

        try {
            System.out.println("Сумма корректного массива: " + sumArray(firstArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Сумма корректного массива: " + sumArray(secondArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            int[] arr = new int[5];
            arr[10] = 42;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException:");
            System.err.println("Ошибка: " + e.getMessage());

        }
    }
}
