package Aston;


import Aston.lesson12.ArrayProcess;
import Aston.lesson12.MyArrayDataException;
import Aston.lesson12.MyArraySizeException;

public class Lesson12 {

    public static void main(String[] args) {
        ArrayProcess process = new ArrayProcess();
        String[][] firstArray =
                {{"5", "7", "12", "1"},
                        {"5", "7", "12", "1"},
                        {"5", "7", "12", "1"},
                        {"5", "7", "12"}};

        String[][] secondArray =
                {{"5", "7", "12", "1"},
                        {"5", "7", "12", "1"},
                        {"5", "7", "12", "1"},
                        {"5", "7", "ххх", "1"}};

        processArray(process, firstArray, "Test 1");
        processArray(process, secondArray, "Test 2");

    }
    private static void processArray(ArrayProcess process, String[][] array, String testName) {
        try {
            int result = process.ProcessArray(array);
            System.out.println("Сумма корректного массива: " + testName);
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
