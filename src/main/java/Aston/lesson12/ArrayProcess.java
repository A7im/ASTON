package Aston.lesson12;

import java.util.Arrays;

class ArrayProcess {
    public int ProcessArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        SizeCheck(array);
        return CalculateSum(array);
    }

    private void SizeCheck(String[][] array) throws MyArraySizeException {
        if (array.length != 4 || Arrays.stream(array).anyMatch(row -> row.length != 4)) {
            throw new MyArraySizeException("Массив должен быть 4x4");
        }
    }

    private int CalculateSum(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
}


