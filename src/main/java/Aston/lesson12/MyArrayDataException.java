package Aston.lesson12;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col, String value) {
        super(String.format("Некорректные данные в указанной ячейке [%d][%d]: '%s'", row, col, value));
    }
}
